package com.venkat.work.visitor;

/**
 * Created by Venkatram on 2/27/2017.
 */
public interface Item {
    public double accept(ShoppingCartVisitor visitor);
}
