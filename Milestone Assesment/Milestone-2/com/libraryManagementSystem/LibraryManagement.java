package com.libraryManagementSystem;

public class LibraryManagement { 
    public static void main(String[] args) { 
        Library library = new Library(); 
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565")); 
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780060935467")); 
        library.addBook(new Book("1984", "George Orwell", "9780451524935")); 
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "9781503290563")); 
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488")); 
        
        System.out.println("All books in the library:"); 
        library.displayBooks(); 
        
        String searchTitle1 = "1984"; 
        System.out.println("\nSearching for \"" + searchTitle1 + "\" using Linear Search:"); 
        Book foundBook1 = library.linearSearch(searchTitle1); 
        System.out.println(foundBook1 != null ? foundBook1 : "Book not found"); 

        String searchTitle2 = "Pride and Prejudice"; 
        System.out.println("\nSearching for \"" + searchTitle2 + "\" using Binary Search:"); 
        Book foundBook2 = library.binarySearch(searchTitle2); 

        System.out.println(foundBook2 != null ? foundBook2 : "Book not found");  
    } 
} 