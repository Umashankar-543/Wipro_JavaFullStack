-- Assignment-2
-- -----------------------------------------------------------
-- INNER JOIN to combine 'orders' and 'customers' tables for customers in a specified region 
SELECT c.customer_id, c.customer_name, c.email, o.order_id, o.order_date 
FROM customers c 
INNER JOIN orders o ON c.customer_id = o.customer_id 
WHERE c.region = 'West'; 
 
-- LEFT JOIN to display all customers including those without orders 
SELECT c.customer_id, c.customer_name, c.email, o.order_id, o.order_date 
FROM customers c 
LEFT JOIN orders o ON c.customer_id = o.customer_id 
WHERE c.region = 'West'; 