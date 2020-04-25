CREATE TABLE departments (
	id    INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(250) NOT NULL
);

CREATE TABLE positions (
	id    INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(250) NOT NULL
);

CREATE TABLE employees (
	id            INT AUTO_INCREMENT PRIMARY KEY,
	first_name    VARCHAR(250) NOT NULL,
	last_name     VARCHAR(250) NOT NULL,
	email         VARCHAR(250) DEFAULT NULL UNIQUE,
	department_id INT          NOT NULL,
	position_id   INT          NOT NULL,
	foreign key (department_id) references departments (id),
	foreign key (position_id) references positions (id)
);
