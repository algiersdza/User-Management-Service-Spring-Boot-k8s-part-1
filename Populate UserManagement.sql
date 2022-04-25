-- INSERT INTO statements for userservice

-- 2 roles, users can have 2 roles concurrently
INSERT INTO role (roleid, rolename, roledescription) VALUES ('1', 'Subscriber', 'Subscriber can only read messages from producers that they subscribe to.');
INSERT INTO role (roleid, rolename, roledescription) VALUES ('2', 'Producer', 'Producer can only create messages.');
INSERT INTO role (roleid, rolename, roledescription) VALUES ('3', 'Producer&Subscriber', 'You can do both!');

-- LAST_SEEN
INSERT INTO last_seen (lastseenid, lastlogintime, lastlogouttime) VALUES ('1','2022-02-10 13:23:44','2022-02-10 14:00:45');
INSERT INTO last_seen (lastseenid, lastlogintime, lastlogouttime) VALUES ('2','2022-01-20 13:23:44','2022-01-20 17:53:23');
INSERT INTO last_seen (lastseenid, lastlogintime, lastlogouttime) VALUES ('3','2022-01-25 13:23:44','2022-01-25 16:02:35');

-- Users (Ibrahim Hermouche producer), (Joe Wo Producer and Subscriber) , (Omar Subscriber)
INSERT INTO user (id, userid, userfirstname, userlastname, useremailaddress, dateregistered, userrole, userlastseen) 
VALUES (1, '8dfab8a0-aa78-11ec-aadd-f02f74f4d78a','Ibrahim','Hermouche','herm@email.com','2021-01-15','2','1');

INSERT INTO user (id, userid, userfirstname, userlastname, useremailaddress, dateregistered, userrole, userlastseen) 
VALUES (2, '8dfb2899-aa78-11ec-aadd-f02f74f4d78a','Joe','Wo','wo@email.com','2021-05-25','3','2');

INSERT INTO user (id, userid, userfirstname, userlastname, useremailaddress, dateregistered, userrole, userlastseen) 
VALUES (3 ,'8dfc16f0-aa78-11ec-aadd-f02f74f4d78a','Omar','Green','green@email.com','2021-08-14','1','3');



