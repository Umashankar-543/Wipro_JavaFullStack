package com.shoppingApp;

import java.util.LinkedList; 
import java.util.Stack;  

public class PurchaseHistory { 
    private Stack<LinkedList<String>> history; 

    public PurchaseHistory() { 
        this.history = new Stack<>(); 
    } 

    public void saveCart(LinkedList<String> cart) { 
        history.push(new LinkedList<>(cart)); 
    } 

    public LinkedList<String> undoLastPurchase() { 
        if (!history.isEmpty()) { 
            return history.pop(); 
        } else { 
            System.out.println("No purchase history available."); 
            return new LinkedList<>(); 
        } 
    } 

    public void viewHistory() { 
        if (history.isEmpty()) { 
            System.out.println("No purchase history available."); 
        } else { 
            System.out.println("Purchase history:"); 
            for (LinkedList<String> cart : history) { 
                System.out.println(cart); 
            } 
        } 
    } 
} 