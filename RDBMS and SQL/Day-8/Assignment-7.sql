-- Insert new records 
INSERT INTO Authors (first_name, last_name) VALUES ('George', 'Orwell'); 
INSERT INTO Categories (category_name) VALUES ('Dystopian'); 
INSERT INTO Books (title, isbn, author_id, category_id) VALUES ('1984', '9780451524935', 1, 1); 
INSERT INTO Members (first_name, last_name, email) VALUES ('John', 'Doe', 'john.doe@example.com'); 
INSERT INTO Loans (book_id, member_id, loan_date, due_date) VALUES (1, 1, '2024-05-01', '2024-05-15'); 

-- Update existing records 
UPDATE Books SET title = 'Nineteen Eighty-Four' WHERE book_id = 1; 
UPDATE Members SET email = 'john.doe@newdomain.com' WHERE member_id = 1;   

-- Delete records based on specific criteria 
DELETE FROM Books WHERE title = 'Nineteen Eighty-Four'; 
DELETE FROM Members WHERE email = 'john.doe@newdomain.com'; 