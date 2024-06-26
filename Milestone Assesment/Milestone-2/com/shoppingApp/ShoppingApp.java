package com.shoppingApp;

public class ShoppingApp { 
    public static void main(String[] args) { 
        ShoppingCart cart = new ShoppingCart(); 
        PurchaseHistory history = new PurchaseHistory(); 
        CustomerService service = new CustomerService(); 
        cart.addItem("Iphone-14"); 
        cart.addItem("Lamp"); 
        cart.viewCart(); 
        cart.removeItem("Iphone-14"); 
        cart.viewCart(); 
        history.saveCart(cart.getItems()); 
        cart.clearCart(); 
        cart.addItem("Shoes"); 
        history.saveCart(cart.getItems()); 
        history.viewHistory(); 
        cart.clearCart(); 
        cart.getItems().addAll(history.undoLastPurchase()); 
        cart.viewCart(); 
        service.addRequest("Issue with order #1234"); 
        service.addRequest("Refund request for item #5678"); 
        service.viewPendingRequests(); 
        service.processNextRequest(); 
        service.viewPendingRequests(); 
    } 
} 