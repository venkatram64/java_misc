package com.venkat.work.akhil;

/**
 * Created by Venkatram on 4/27/2017.
 */
public class ShapeTest {

    public static Shape createCircle(int r){
        return new Circle(r);
    }

    public static Shape createRectancle(int length, int breadth){
        return new Rectangle(length, breadth);
    }

    public static void main(String[] args){

        Shape circle = ShapeTest.createCircle(5);// new Circle(5);
        System.out.println("Circle area: " + circle.area());

        Shape rect = ShapeTest.createRectancle(4,5);//new Rectangle(4,5);
        System.out.println("Rectangle area:" + rect.area());
    }
}
