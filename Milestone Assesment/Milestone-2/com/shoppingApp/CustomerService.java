package com.shoppingApp;

import java.util.LinkedList; 
import java.util.Queue; 

public class CustomerService { 
    private Queue<String> serviceRequests; 

    public CustomerService() { 
        this.serviceRequests = new LinkedList<>(); 
    } 

    public void addRequest(String request) { 
        serviceRequests.add(request); 
    } 

    public void processNextRequest() { 
        if (!serviceRequests.isEmpty()) { 
            System.out.println("Processing request: " + serviceRequests.poll()); 
        } else { 
            System.out.println("No pending customer service requests."); 
        } 
    } 

    public void viewPendingRequests() { 
        if (serviceRequests.isEmpty()) { 
            System.out.println("No pending customer service requests."); 
        } else { 
            System.out.println("Pending customer service requests:"); 
            for (String request : serviceRequests) { 
                System.out.println("- " + request); 
            } 
        } 
    } 
} 