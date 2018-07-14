package com.venkat.java8;

/**
 * Created by Venkatram on 3/10/2017.
 */

@FunctionalInterface
public interface Condition {
    public boolean test(Person p);
}
