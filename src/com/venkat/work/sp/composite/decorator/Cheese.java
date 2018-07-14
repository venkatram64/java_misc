package com.venkat.work.sp.composite.decorator;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class Cheese extends PizzaTopping {

    public Cheese(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String description() {
        return  pizza.description() + " with Cheese";
    }

    @Override
    public double cost() {
        return pizza.cost() + 2.5;
    }
}
