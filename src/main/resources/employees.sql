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