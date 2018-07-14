package com.venkat.work.sp.composite;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class DrawingTest {

    public static void main(String[] args){
        Shape circle = new Circle();
        Shape triangle = new Triangle();

        Drawing drawing = new Drawing();
        drawing.add(circle);
        drawing.add(triangle);
        drawing.draw();
        drawing.clear();
    }
}
