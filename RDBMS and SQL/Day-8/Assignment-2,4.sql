-- Create the database 
CREATE DATABASE LibraryDB; 

-- Use the newly created database 
USE LibraryDB; 

-- Create the Authors table 
CREATE TABLE Authors ( 
    author_id INT PRIMARY KEY AUTO_INCREMENT, 
    first_name VARCHAR(50) NOT NULL, 
    middle_name VARCHAR(50), 
    last_name VARCHAR(50) NOT NULL 
); 

-- Create the Categories table 
CREATE TABLE Categories ( 
    category_id INT PRIMARY KEY AUTO_INCREMENT, 
    category_name VARCHAR(100) NOT NULL UNIQUE 
); 

-- Create the Books table 
CREATE TABLE Books ( 
    book_id INT PRIMARY KEY AUTO_INCREMENT, 
    title VARCHAR(100) NOT NULL, 
    isbn VARCHAR(13) NOT NULL UNIQUE, 
    author_id INT NOT NULL, 
    category_id INT NOT NULL, 
    FOREIGN KEY (author_id) REFERENCES Authors(author_id), 
    FOREIGN KEY (category_id) REFERENCES Categories(category_id) 
); 

-- Create the Members table 
CREATE TABLE Members ( 
    member_id INT PRIMARY KEY AUTO_INCREMENT, 
    first_name VARCHAR(50) NOT NULL, 
    last_name VARCHAR(50) NOT NULL, 
    email VARCHAR(100) NOT NULL UNIQUE, 
    phone_number VARCHAR(15) 
); 

-- Create the Loans table 
CREATE TABLE Loans ( 
    loan_id INT PRIMARY KEY AUTO_INCREMENT, 
	book_id INT NOT NULL, 
    member_id INT NOT NULL, 
    loan_date DATE NOT NULL, 
    due_date DATE NOT NULL, 
	FOREIGN KEY (book_id) REFERENCES Books(book_id), 
    FOREIGN KEY (member_id) REFERENCES Members(member_id) 
); 

-- Drop the redundant OldCategories table (if it exists) 
DROP TABLE IF EXISTS OldCategories; 