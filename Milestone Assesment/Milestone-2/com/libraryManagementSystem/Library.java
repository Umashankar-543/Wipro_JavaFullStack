package com.libraryManagementSystem;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List; 
  

public class Library { 
    private List<Book> books; 

    public Library() { 
        this.books = new ArrayList<>(); 
    } 

    public void addBook(Book book) { 
        books.add(book); 
        Collections.sort(books); 
    } 

    public boolean removeBook(String title) { 
        for (Book book : books) { 
            if (book.getTitle().equalsIgnoreCase(title)) { 
                books.remove(book); 
                return true; 
            } 
        } 
        return false; 
    } 

    public void displayBooks() { 
        for (Book book : books) { 
            System.out.println(book); 
        } 
    } 

    public Book linearSearch(String title) { 
        for (Book book : books) { 
            if (book.getTitle().equalsIgnoreCase(title)) { 
                return book; 
            } 
        } 
        return null; 
    } 

    public Book binarySearch(String title) { 
        int left = 0; 
        int right = books.size() - 1; 
        while (left <= right) { 
            int mid = (left + right) / 2; 
            Book midBook = books.get(mid); 
            int cmp = midBook.getTitle().compareToIgnoreCase(title); 
            if (cmp < 0) { 
                left = mid + 1; 
            } else if (cmp > 0) { 
                right = mid - 1; 
            } else { 
                return midBook; 
            } 
        } 
        return null; 
    } 
} 