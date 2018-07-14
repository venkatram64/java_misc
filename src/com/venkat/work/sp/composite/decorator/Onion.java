package com.venkat.work.sp.composite.decorator;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class Onion extends PizzaTopping {

    public Onion(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String description() {
        return pizza.description() + " with Onion";
    }

    @Override
    public double cost() {
        return pizza.cost() + 2.0;
    }
}
