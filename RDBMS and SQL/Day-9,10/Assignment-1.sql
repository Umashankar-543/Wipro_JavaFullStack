-- Create database for Day9
CREATE DATABASE Day9;

-- Using database Day9
USE Day9;

-- Create the customers table 
CREATE TABLE customers ( 
    customer_id INT PRIMARY KEY, 
    customer_name VARCHAR(255) NOT NULL, 
    email VARCHAR(255) NOT NULL, 
    city VARCHAR(100), 
    region VARCHAR(100) 
); 
 
-- Create the orders table 
CREATE TABLE orders ( 
    order_id INT PRIMARY KEY, 
    customer_id INT, 
    order_value DECIMAL(10, 2), 
    order_date DATE, 
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) 
); 

 -- Insert sample data into customers table 
INSERT INTO customers (customer_id, customer_name, email, city, region) VALUES 
(1, 'Alice Johnson', 'alice@example.com', 'New York', 'East'), 
(2, 'Bob Smith', 'bob@example.com', 'Los Angeles', 'West'), 
(3, 'Charlie Brown', 'charlie@example.com', 'Chicago', 'North'), 
(4, 'David Wilson', 'david@example.com', 'Houston', 'South'), 
(5, 'Eva Davis', 'eva@example.com', 'Phoenix', 'West'); 
 
-- Insert sample data into orders table 
INSERT INTO orders (order_id, customer_id, order_value, order_date) VALUES 
(101, 1, 150.00, '2024-05-01'), 
(102, 1, 200.00, '2024-05-02'), 
(103, 2, 300.00, '2024-05-03'), 
(104, 3, 250.00, '2024-05-04'), 
(105, 4, 400.00, '2024-05-05'), 
(106, 5, 100.00, '2024-05-06');

-- -----------------------------------------------------------
-- Assignment-1
-- -----------------------------------------------------------
-- Retrieving All Columns from Customers Table 
SELECT * FROM customers; 

-- Retrieving Customer Name and Email Address for Customers in a Specific City 
SELECT customer_name, email  
FROM customers  
WHERE city = 'New York'; 