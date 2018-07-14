package com.venkat.work.visitor;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class Book implements Item {
    private double price;
    private String name;

    public Book(double price, String name){
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
