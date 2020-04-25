INSERT INTO departments(id, title)
VALUES (1, 'IT'),
       (2, 'HR');

INSERT INTO positions(id, title)
VALUES (1, 'Developer'),
       (2, 'Tester'),
       (3, 'Manager'),
       (4, 'CEO');

INSERT INTO employees (first_name, last_name, email, department_id, position_id)
VALUES ('John', 'Doe', 'john.doe@gmail.com', 1, 1),
       ('Jane', 'Doe', 'jane.doe@gmail.com', 1, 1),
       ('Michael', 'Hunter', 'michael.hunter@gmail.com', 1, 1),
       ('Agnes', 'Mills', 'agnes.mills@gmail.com', 1, 1),
       ('Deborah', 'Horn', 'deborah.horn@gmail.com', 1, 2),
       ('William', 'Franklin', 'william.franklin@gmail.com', 1, 2),
       ('Mary', 'Brown', 'mary.brown@gmail.com', 1, 3),
       ('Jimmy', 'Doe', 'jimmy.doe@gmail.com', 2, 3),
       ('Kevin', 'Poirier', 'kevin.poirier@gmail.com', 2, 4);
