-- Assignment-3
-- -----------------------------------------------------------
-- Subquery to Find Customers with Orders Above the Average Order Value
SELECT c.customer_id, c.customer_name, c.email, o.order_value 
FROM customers c 
JOIN orders o ON c.customer_id = o.customer_id 
WHERE o.order_value > (SELECT AVG(order_value) FROM orders); 
 
-- UNION to combine customers with orders above average value and customers from a specific region 
SELECT customer_id, customer_name, email, order_value 
FROM ( 
    SELECT c.customer_id, c.customer_name, c.email, o.order_value 
    FROM customers c 
    JOIN orders o ON c.customer_id = o.customer_id 
    WHERE o.order_value > (SELECT AVG(order_value) FROM orders) 
    UNION 
    SELECT customer_id, customer_name, email, NULL AS order_value 
    FROM customers 
    WHERE region = 'North' 
) AS combined_results; 