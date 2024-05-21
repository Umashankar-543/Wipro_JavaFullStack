-- Create an index on the title column
CREATE INDEX idx_title ON Books(title); 

-- Example query to show improved performance with index 
SELECT * FROM Books WHERE title = 'Some Book Title'; 

-- Drop the index on the title column 
DROP INDEX idx_title ON Books; 

-- Example query to show performance impact without index 
SELECT * FROM Books WHERE title = 'Some Book Title'; 