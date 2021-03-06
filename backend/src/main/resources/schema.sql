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

CREATE TABLE users (
	id       INT AUTO_INCREMENT PRIMARY KEY,
	email    VARCHAR(250) DEFAULT NULL UNIQUE,
	password VARCHAR(250) DEFAULT NULL UNIQUE
);

CREATE VIEW v_departments
		(
		 id,
		 title,
		 employee_count
		)
AS
	SELECT
		d.id,
		d.title,
		COUNT(e.id)
	FROM departments d
	     JOIN employees e ON d.id = e.department_id
	GROUP BY d.id;
