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