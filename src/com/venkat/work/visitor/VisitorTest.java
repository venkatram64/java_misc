package com.venkat.work.visitor;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class VisitorTest {
    public  static void main(String[] args){
        Item[] items = new Item[]{new Book(40,"story of venkatram"), new Book(60, "story of venkat"),
                                new Fruit(10,2,"Banana"), new Fruit(5,5,"Apple")};

        ShoppingCartVisitor scv = new ShoppingCartVisitorImpl();
        double sum = 0;
        for(Item item : items){
            sum += item.accept(scv);
        }
        System.out.println(sum);
    }
}
