-- Create the products table 
CREATE TABLE products ( 
    product_id INT PRIMARY KEY, 
    product_name VARCHAR(255) NOT NULL, 
    price DECIMAL(10, 2) NOT NULL, 
    stock_quantity INT NOT NULL 
); 

 -- -------------------------------------------------
 
-- Begin the transaction 
START TRANSACTION; 

-- Insert a new record into the 'orders' table 
INSERT INTO orders (order_id, customer_id, order_value, order_date) VALUES (111, 5, 150.00, '2024-05-14'); 

-- Commit the transaction 
COMMIT;   

-- Update the 'products' table (decrease stock quantity by 1 for product with ID 123) 
UPDATE products SET stock_quantity = stock_quantity - 1 WHERE product_id = 123;   

-- Rollback the transaction 
ROLLBACK; 