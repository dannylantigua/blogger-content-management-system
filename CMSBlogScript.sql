DROP DATABASE IF EXISTS BlogCMS;

CREATE DATABASE BlogCMS;

USE BlogCMS;

CREATE TABLE Entity(
recordId INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
FirstName VARCHAR(20),
LastName VARCHAR(20),
EMAIL VARCHAR(25),
PhoneNumber VARCHAR(10),
AboutMe TEXT,
UserName VARCHAR(30),
passwd VARCHAR(50),
isAdmin boolean
);

CREATE TABLE EntitySocialProfiles(
EntityId INT,
WebName VARCHAR(20),
Website VARCHAR(100),
FOREIGN KEY (EntityId) REFERENCES Entity(recordId)
);

CREATE TABLE Categories(
recordId INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
CategoryName VARCHAR(20)
);

CREATE TABLE Posts(
recordId INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
postTittle TEXT,
postBody TEXT,
userId INT,
postDate DateTime,
expireDate DateTime,
likes INT,
isPending boolean,
isApproved boolean,
isRejected boolean,
FOREIGN KEY (userId) REFERENCES Categories (recordId)
);

CREATE TABLE PostsTags(
postId INT,
Tag VARCHAR(30),
FOREIGN KEY (postId) REFERENCES Posts (recordId)
);

CREATE TABLE StaticPages(
recordId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
PageName Varchar(20),
Content TEXT
);