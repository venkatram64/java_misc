package com.venkat.work.observer;

/**
 * Created by Venkatram on 2/26/2017.
 */
public class Customer implements Observer {

    private Subject subject;
    private String customerName;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(String productName) {
        System.out.println("Hello " + customerName + ", product is available on Amazon site " + productName);
    }
}
