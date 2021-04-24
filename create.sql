CREATE DATABASE physiotherapy_and_sports_injury_booking;
\c physiotherapy_and_sports_injury_booking;

CREATE TABLE IF NOT EXISTS physician (physicianId int PRIMARY KEY, fullName VARCHAR,
address VARCHAR, telephoneNo VARCHAR, expertiseAreas VARCHAR);

CREATE TABLE IF NOT EXISTS patient (patientId int PRIMARY KEY, fullName VARCHAR,
address VARCHAR, telephoneNo VARCHAR);

CREATE TABLE IF NOT EXISTS visitor (visitorId int PRIMARY KEY, fullName VARCHAR,
 address VARCHAR, telephoneNo VARCHAR);

CREATE TABLE IF NOT EXISTS room (roomId int PRIMARY KEY, roomName VARCHAR);

CREATE TABLE IF NOT EXISTS treatment (treatmentId int PRIMARY KEY, treatmentName VARCHAR,
 room VARCHAR, period TIMESTAMP, physicianName VARCHAR, patientId int);

\q



CREATE DATABASE physiotherapy_and_sports_injury_booking_test WITH TEMPLATE physiotherapy_and_sports_injury_booking;