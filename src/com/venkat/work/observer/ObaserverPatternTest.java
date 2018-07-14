package com.venkat.work.observer;

/**
 * Created by Venkatram on 2/26/2017.
 */
public class ObaserverPatternTest {

    public static void main(String[] args){

        Product p = new Product();
        p.setProductName("Apple iPhone 7");


        Customer c1 = new Customer();
        c1.setCustomerName("Venkatram");
        //c1.setSubject(p);
        //c1.getSubject().registerObserver(c1);
        p.registerObserver(c1);

        Customer c2 = new Customer();
        c2.setCustomerName("Srijan");
        //c2.setSubject(p);
        //c2.getSubject().registerObserver(c2);
        p.registerObserver(c2);

        p.setAvailable(true);

    }
}
