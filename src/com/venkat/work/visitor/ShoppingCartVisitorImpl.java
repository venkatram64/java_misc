package com.venkat.work.visitor;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    @Override
    public double visit(Book book) {
        if(book.getPrice() > 50){
            return book.getPrice() - 5;
        }
        return book.getPrice();
    }

    @Override
    public double visit(Fruit fruit) {
        return fruit.getPricePerKg() * fruit.getWeight();
    }
}
