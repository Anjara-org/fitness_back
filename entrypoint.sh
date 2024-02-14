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
docker build -t "$APP_NAME":latest -f Dockerfile .

echo "-----------Pushing image to dockerhub------------"
echo "${DOCKERHUB_PASSWORD}" | docker login -u "${DOCKERHUB_USERNAME}" --password-stdin
docker tag "${APP_NAME}":latest "${DOCKERHUB_USERNAME}"/"${DOCKERHUB_REPO}":latest
docker push "${DOCKERHUB_USERNAME}"/"${DOCKERHUB_REPO}":latest

echo "-----------Project deployed successfully !------------"
echo "
Enjoy your day !
Copyright ©, Anjara.org
"