package com.venkat.work.sp.composite.decorator;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class OrderPizza {

    public static void main(String[] args){
        Pizza panPizza = new PanPizza();
        panPizza = new Tomato(panPizza);
        panPizza = new Onion(panPizza);
        panPizza = new Cheese(panPizza);
        System.out.println("You ordered pizza ");
        System.out.println(panPizza.description() + "   " + panPizza.cost());
    }
}
