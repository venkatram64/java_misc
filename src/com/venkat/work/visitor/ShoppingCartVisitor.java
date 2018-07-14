package com.venkat.work.visitor;

/**
 * Created by Venkatram on 2/27/2017.
 */
public interface ShoppingCartVisitor {

    double visit(Book book);
    double visit(Fruit fruit);
}
