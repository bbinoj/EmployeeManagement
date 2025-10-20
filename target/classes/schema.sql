CREATE DATABASE IF NOT EXISTS employee_management;
USE employee_management;

-- ==========================
-- DEPARTMENT TABLE
-- ==========================
CREATE TABLE department (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    creation_date VARCHAR(10),
    department_head INT NULL
);

-- ==========================
-- EMPLOYEE TABLE
-- ==========================
CREATE TABLE employee (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    dob VARCHAR(10),
    salary DECIMAL(10,2),
    address VARCHAR(255),
    role VARCHAR(50),
    joining_date VARCHAR(10),
    bonus VARCHAR(10),
    department_id INT,
    manager_id INT,
    FOREIGN KEY (department_id) REFERENCES department(department_id) ON DELETE SET NULL,
    FOREIGN KEY (manager_id) REFERENCES employee(employee_id) ON DELETE SET NULL
);
