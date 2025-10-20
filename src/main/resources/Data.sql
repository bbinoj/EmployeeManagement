INSERT INTO department (name, creation_date) VALUES 
('IT', '2022-02-02'),
('HR', '2022-03-01'),
('Finance', '2022-04-01');

-- Insert Employees
INSERT INTO employee (name, dob, salary, address, role, joining_date, bonus, department_id, manager_id)
VALUES 
('Alice', '1990-01-01', 70000, 'City A', 'Developer', '2022-05-01', '10%', 1, NULL),
('Bob', '1992-02-02', 65000, 'City B', 'Developer', '2022-06-01', '8%', 1, 1),
('Charlie', '1993-03-03', 60000, 'City C', 'QA Engineer', '2022-07-01', '7%', 1, 1),
('David', '1994-04-04', 62000, 'City D', 'Developer', '2022-08-01', '6%', 1, 1),
('Eve', '1991-05-05', 68000, 'City E', 'Team Lead', '2022-09-01', '10%', 1, 1),

('Fiona', '1988-06-06', 50000, 'City F', 'HR Executive', '2022-05-01', '5%', 2, NULL),
('George', '1989-07-07', 52000, 'City G', 'HR Coordinator', '2022-06-01', '5%', 2, 6),
('Hannah', '1990-08-08', 51000, 'City H', 'HR Coordinator', '2022-07-01', '5%', 2, 6),
('Ian', '1991-09-09', 53000, 'City I', 'HR Manager', '2022-08-01', '8%', 2, 6),
('Jane', '1992-10-10', 54000, 'City J', 'HR Assistant', '2022-09-01', '5%', 2, 6),

('Kevin', '1990-11-11', 60000, 'City K', 'Accountant', '2022-05-01', '7%', 3, NULL),
('Laura', '1991-12-12', 62000, 'City L', 'Accountant', '2022-06-01', '7%', 3, 11),
('Mike', '1992-01-13', 65000, 'City M', 'Finance Manager', '2022-07-01', '10%', 3, 11),
('Nina', '1993-02-14', 58000, 'City N', 'Finance Analyst', '2022-08-01', '6%', 3, 11),
('Oscar', '1994-03-15', 59000, 'City O', 'Finance Analyst', '2022-09-01', '6%', 3, 11),

('Paul', '1995-04-16', 57000, 'City P', 'Developer', '2022-10-01', '5%', 1, 1),
('Quinn', '1996-05-17', 56000, 'City Q', 'QA Engineer', '2022-11-01', '5%', 1, 1),
('Rachel', '1997-06-18', 55000, 'City R', 'Developer', '2022-12-01', '5%', 1, 1),
('Steve', '1990-07-19', 54000, 'City S', 'HR Assistant', '2022-10-01', '5%', 2, 6),
('Tina', '1991-08-20', 53000, 'City T', 'HR Coordinator', '2022-11-01', '5%', 2, 6),
('Uma', '1992-09-21', 52000, 'City U', 'Finance Analyst', '2022-12-01', '6%', 3, 11),
('Victor', '1993-10-22', 51000, 'City V', 'Accountant', '2023-01-01', '7%', 3, 11),
('Wendy', '1994-11-23', 50000, 'City W', 'Developer', '2023-02-01', '5%', 1, 1),
('Xavier', '1995-12-24', 49000, 'City X', 'QA Engineer', '2023-03-01', '5%', 1, 1),
('Yara', '1996-01-25', 48000, 'City Y', 'HR Assistant', '2023-04-01', 2, 6),
('Zane', '1997-02-26', 47000, 'City Z', 'Finance Analyst', '2023-05-01', 3, 11);
