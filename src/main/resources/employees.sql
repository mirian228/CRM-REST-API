CREATE DATABASE IF NOT EXISTS employee_directory;
USE employee_directory;

CREATE TABLE employee (
	id int NOT NULL AUTO_INCREMENT,
    first_name varchar(45) DEFAULT NULL,
    last_name varchar(45) DEFAULT NULL,
    email varchar(45) DEFAULT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO employee VALUES
		(1, 'Leslie', 'Andrews', 'leslie@gmail.com'),
        (2, 'Emma', 'Baugmarten', 'emma@gmail.com'),
		(3, 'Avani', 'Gupta', 'avani@gmail.com'),
        (4, 'Yuri', 'Petrov', 'yuri@gmail.com'),
        (5, 'Juan', 'Vega', 'juan@gmail.com');
        
        
CREATE TABLE manager(
	id int NOT NULL auto_increment,
    first_name varchar(45) DEFAULT NULL,
    last_name varchar(45) DEFAULT NULL,
    email varchar(45) DEFAULT NULL,
    primary key(id)
) ENGINE=InnoDB auto_increment=1 default charset=latin1;


ALTER TABLE employee ADD COLUMN manager_id int;
ALTER TABLE employee ADD FOREIGN KEY (manager_id) REFERENCES manager(id);

INSERT INTO manager VALUES 
		(1, 'Iuna', 'Vanidze', 'iunona.vanidze@gmail.com'),
        (2, 'Mirian', 'Surmanidze', 'mirian.surmanidze@gmail.com'),
        (3, 'Leila', 'Bolkvadze', 'leila.bolkvadze@gmail.com');
        
        
truncate table employee;

CREATE TABLE users (
	username varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    enabled tinyint NOT NULL,
    
	PRIMARY KEY(username)
) Engine=InnoDB default charset=latin1;

INSERT INTO users VALUES
				('john', '{noop}test123', 1),
                ('mary', '{noop}test123', 1),
                ('susan', '{noop}test123', 1);

CREATE Table authorities (
	username varchar(50) NOT NULL,
	authority varchar(50) NOT NULL,
    
    UNIQUE KEY authorities_idx_1 (username, authority),
    
    CONSTRAINT authorities_ibfk_1
    FOREIGN KEY (username) REFERENCES users(username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO authorities VALUES 
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN');

ALTER table users change column password password char(68);
UPDATE users SET password='{bcrypt}$2a$10$xtKOuARInc5E3AZFqf2dsOpiuoFh2CJDIBlSYIMPbqAnIqFKDPW/O' WHERE username='john';
UPDATE users SET password='{bcrypt}$2a$10$XuTXQhqs8MKxPNYC9Ca1tOKDu1UrCFeBq.9Iu22H9CVy.8Ha/DHi2' WHERE username='mary';
UPDATE users SET password='{bcrypt}$2a$10$tpgXhnrLLwHuvxe6JtePreBsj.XOmFNsaU8N.2k8Gybm3ywWPAwqu' WHERE username='susan';
