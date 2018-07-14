package com.venkat.solid;

import com.venkat.solid.iface.FlatShape;

/**
 * Created by Venkatram on 2/20/2017.
 */
public class Circle implements FlatShape {
    private Point r;

    public Circle(Point r){
        this.r = r;
        System.out.println(" inside circle : " + r.hashCode());
    }
    @Override
    public double area() {
        return Math.PI * Math.pow(this.r.getLocation(),2);
    }
}
