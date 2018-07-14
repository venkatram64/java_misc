package com.venkat.solid;

/**
 * Created by Venkatram on 2/20/2017.
 */
public class Point {
    private double location;

    public Point(int location){
        this.location = location;
    }

    public double getLocation(){
        return this.location;
    }

    public static void swap(Point p1, Point p2){
        Point temp = p1;
        p1 = p2;
        p2 = temp;
    }

    public final static void main(String[] args){
        Point p1 = new Point(5);
        Point p2 = new Point(6);
        System.out.println("Before swap : " + p1.getLocation() + ", " + p2.getLocation());
        swap(p1, p2);
        System.out.println("Before swap : " + p1.getLocation() + ", " + p2.getLocation());
    }

}
