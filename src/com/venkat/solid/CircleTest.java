package com.venkat.solid;

import jdk.nashorn.internal.objects.NativeRegExp;

/**
 * Created by Venkatram on 2/20/2017.
 */
public class CircleTest {

    public static void test(){
        final byte a = 3;
        final byte b = 4;
        byte c = 3 + 4;
        System.out.println(c);
    }

    public static void add(){
        String s1 = "venkat";
        String s2 = s1.concat("ram");
        System.out.println(s2);
    }
    public static void main(String[] args) {
        Point p = new Point(5);
        System.out.println(p.hashCode());
        Circle c = new Circle(p);
        System.out.println(" test circle : " + c.area());
        test();
        add();
    }
}
