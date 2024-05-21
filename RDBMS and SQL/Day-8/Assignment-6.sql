-- Create a new user 
CREATE USER 'uma'@'localhost' IDENTIFIED BY 'uma123';   

-- Grant specific privileges to the new user 
GRANT SELECT, INSERT, UPDATE, DELETE ON librarydb.* TO 'uma'@'localhost'; 

-- Revoke specific privileges from the user 
REVOKE DELETE ON librarydb.* FROM 'uma'@'localhost'; 

-- Drop the user 
DROP USER 'uma'@'localhost'; 