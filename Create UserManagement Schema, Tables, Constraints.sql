CREATE DATABASE IF NOT EXISTS userservice;
USE userservice;
CREATE TABLE user
(
	id INT AUTO_INCREMENT,
	userid VARCHAR(36),
    userfirstname VARCHAR(20),
    userlastname VARCHAR(20),
    useremailaddress VARCHAR(40),
    dateregistered VARCHAR(10),
    userrole INT,
    userlastseen INT,
    CONSTRAINT UserID_PK PRIMARY KEY (id)
);

CREATE TABLE role
(
	roleid INT,
	rolename VARCHAR(20),
    roledescription VARCHAR(100),
    CONSTRAINT RoleID_PK PRIMARY KEY (roleid)
);

CREATE TABLE last_seen
(
	lastseenid INT,
    lastlogintime VARCHAR(20),
    lastlogouttime VARCHAR(20),
    CONSTRAINT LastSeenID_PK PRIMARY KEY (lastseenid)
);

ALTER TABLE user
	ADD CONSTRAINT UserRole_FK FOREIGN KEY (userrole) REFERENCES role (roleid);
ALTER TABLE user    
	ADD CONSTRAINT UserLastSeen_FK FOREIGN KEY (userlastseen) REFERENCES last_seen (lastseenid);