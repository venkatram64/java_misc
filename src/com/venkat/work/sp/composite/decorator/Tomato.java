package com.venkat.work.sp.composite.decorator;

/**
 * Created by Venkatram on 2/27/2017.
 */

public class Tomato extends PizzaTopping {

    public Tomato(Pizza pizza){
        this.pizza = pizza;
    }

    public String description(){
        return pizza.description() + " with Tomato ";
    }

    public double cost(){
        return pizza.cost() + 1.0;
    }
}
