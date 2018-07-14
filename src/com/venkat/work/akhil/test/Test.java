package com.venkat.work.akhil.test;

import com.venkat.work.akhil.nikhil.Other;

/**
 * Created by Venkatram on 4/27/2017.
 */
public class Test {
    public String lo = "lo";

    public static void main(String[] args){
        Test t = new Test();

        String hello = "Hello";
        String lo = "lo";

        String temp = new String("Akhil");
        String temp2 = new String("Akhil");

        System.out.println(temp == temp2);
        System.out.println(temp.equals(temp2));

        System.out.println((Other.hello == hello) + "");
        //System.out.print((Other.hello == hello) + " ");
        System.out.println((hello == ("Hel"+"lo")) + " ");
        String tt = "Hel" + t.lo;
        System.out.println((hello == tt) + " ");

        System.out.println(hello.equals(tt) + " ");

        System.out.println(hello == ("Hel"+lo).intern());

        //StringBuffer

        StringBuffer sb = new StringBuffer();
        sb.append("test.");
        sb.append("another test");

        //StringBuilder

        StringBuilder sb1 = new StringBuilder();
        sb1.append("test");
    }

}