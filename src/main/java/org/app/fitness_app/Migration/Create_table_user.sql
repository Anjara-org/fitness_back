CREATE TABLE "user" (
    Id SERIAL primary key,
    Name VARCHAR(50) NOT NULL,
    First_name VARCHAR(20) NOT NULL,
    Email VARCHAR(20) CHECK ( Email like '%@%') UNIQUE,
    Password VARCHAR(20) NOT NULL
)