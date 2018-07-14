package com.venkat.work.sp.composite.decorator;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class PanPizza implements Pizza {
    @Override
    public String description() {
        return "Pan Pizza";
    }

    @Override
    public double cost() {
        return 10.0;
    }
}
