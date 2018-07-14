package com.venkat.work.visitor;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class Fruit implements Item {

    private double pricePerKg;
    private double weight;
    private String name;

    public Fruit(double pricePerKg, double weight, String name){
        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.name = name;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
