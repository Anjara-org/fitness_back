#!/bin/bash

echo "-----------Installing docker------------"
# Add Docker's official GPG key:
apt-get update && apt-get upgrade -y
apt-get install -y ca-certificates curl
install -m 0755 -d /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
chmod a+r /etc/apt/keyrings/docker.asc

# Add the repository to Apt sources:
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "$VERSION_CODENAME") stable" | \
  tee /etc/apt/sources.list.d/docker.list > /dev/null
apt-get update

# Install docker
apt-get install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

clear
echo "-----------Installing openjdk 19------------"
apt-get install -y openjdk-19-jdk

echo "-----------Building project and packaging Jar file------------"
./mvnw clean install package -DskipTests

echo "-----------Building image------------"
echo "
FROM openjdk:19
LABEL authors='anjara_org'
VOLUME /tmp
WORKDIR /app
ENV DB_USERNAME=$DB_USERNAME
ENV DB_PASSWORD=$DB_PASSWORD
ENV DB_URL=$DB_URL
COPY target/*.jar "$APP_NAME".jar
ENTRYPOINT ["\"java\"", "\"-jar\"", "\"$APP_NAME.jar\""]
" > Dockerfile

docker prune -a
docker build --no-cache -t "$APP_NAME":latest -f Dockerfile .

echo "-----------Pushing image to dockerhub------------"
apt-get install -y jq
DKR_TOKEN=$(curl -s -X POST -H "Content-Type: application/json" \
https://hub.docker.com/v2/users/login \
-d "{"\"username\"": \"$DOCKERHUB_USERNAME\", \"password\": \"$DOCKERHUB_PASSWORD\"}" | jq -r '.token')
DKR_API_REPO="https://hub.docker.com/v2/repositories"
curl -s -X DELETE -H "Authorization: Bearer $DKR_TOKEN" \
"$DKR_API_REPO"/"$DOCKERHUB_USERNAME"/"$APP_NAME"/tags/latest
echo "${DOCKERHUB_PASSWORD}" | docker login -u "${DOCKERHUB_USERNAME}" --password-stdin
docker tag "${APP_NAME}":latest "${DOCKERHUB_USERNAME}"/"${DOCKERHUB_REPO}":latest
sleep 30
docker push "${DOCKERHUB_USERNAME}"/"${DOCKERHUB_REPO}":latest
