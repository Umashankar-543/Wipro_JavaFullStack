package com.shoppingApp;

import java.util.LinkedList; 

public class ShoppingCart { 
    private LinkedList<String> cart; 

    public ShoppingCart() { 
        this.cart = new LinkedList<>(); 
    } 

    public void addItem(String item) { 
        cart.add(item); 
    } 

    public void removeItem(String item) { 
        cart.remove(item); 
    } 

    public void viewCart() { 
        if (cart.isEmpty()) { 
            System.out.println("Shopping cart is empty."); 
        } else { 
            System.out.println("Items in the shopping cart:"); 
            for (String item : cart) { 
                System.out.println("- " + item); 
            } 
        } 
    } 

    public LinkedList<String> getItems() { 
        return new LinkedList<>(cart); 
    } 

    public void clearCart() { 
        cart.clear(); 
    } 
} 