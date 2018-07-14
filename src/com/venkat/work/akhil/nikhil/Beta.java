package com.venkat.work.akhil.nikhil;

/**
 * Created by Venkatram on 4/27/2017.
 */
public class Beta extends Baap{

    public int h = 44;
    public int getH() {
        System.out.println("Beta " + h);
        return h;
    }

    public void some(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        Baap b = new Beta();
        System.out.println(b.h + " " + b.getH());

        Beta bb = (Beta) b;

        System.out.println(bb.h + " " + bb.getH());
    }

}
