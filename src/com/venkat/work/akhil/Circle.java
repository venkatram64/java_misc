package com.venkat.work.akhil;

/**
 * Created by Venkatram on 4/27/2017.
 */
public class Circle implements Shape {

    private final int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }


}
