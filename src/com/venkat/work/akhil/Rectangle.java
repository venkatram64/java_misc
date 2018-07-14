package com.venkat.work.akhil;

/**
 * Created by Venkatram on 4/27/2017.
 */
public class Rectangle implements Shape {

    private final int length;
    private final int breadth;

    public Rectangle(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }
    @Override
    public double area() {
        return length * breadth;
    }
}
