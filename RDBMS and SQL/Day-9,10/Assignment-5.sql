-- Start the transaction 
START TRANSACTION; 

-- First INSERT 
INSERT INTO orders (order_id, customer_id, order_value, order_date) VALUES (107, 1, 180.00, '2024-05-10'); 

-- Savepoint 1 
SAVEPOINT savepoint1; 

-- Second INSERT 
INSERT INTO orders (order_id, customer_id, order_value, order_date) VALUES (108, 2, 220.00, '2024-05-11'); 

-- Savepoint 2 
SAVEPOINT savepoint2; 

-- Third INSERT 
INSERT INTO orders (order_id, customer_id, order_value, order_date) VALUES (109, 3, 270.00, '2024-05-12'); 

-- Savepoint 3 
SAVEPOINT savepoint3;   

-- Fourth INSERT 
INSERT INTO orders (order_id, customer_id, order_value, order_date) VALUES (110, 4, 320.00, '2024-05-13'); 

-- Savepoint 4 
SAVEPOINT savepoint4; 

-- Rollback to the second savepoint 
ROLLBACK TO savepoint2; 

-- Commit the overall transaction 
COMMIT; 