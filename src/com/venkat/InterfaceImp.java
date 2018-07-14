package com.venkat;

/**
 * Created by Venkatram on 5/6/2017.
 */
public class InterfaceImp implements InterfaceOne,InterfaceTwo {

    @Override
    public void m1() {
        System.out.println("Hi");
    }

    public static void main(String[] args){
        InterfaceTwo two = new InterfaceImp();
        two.m1();
        System.out.println(two.test);

        InterfaceOne one = new InterfaceImp();
        one.m1();
        System.out.println(one.test);

        InterfaceImp imp = new InterfaceImp();
        imp.m1();
        //System.out.println(imp.test);


    }
}
