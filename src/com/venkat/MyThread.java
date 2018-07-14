package com.venkat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Venkatram on 4/26/2017.
 */
public class MyThread {
    //non generic
    public static List add1(String[] strList){
        List l = new ArrayList();
        for(String s: strList){
            l.add(s);
        }
        return l;
    }
    //generic method
    public static <T> List<T> add(T[] arr){

        List<T> l = new ArrayList<>();
        for(T s: arr){
            l.add(s);
        }
        return l;
    }

    public static void main(String[] args){

        String[] strArray = new String[]{"Venkat","123","reddy"};

        List<String> lstr1 = add(strArray);
        //printing strings
        for(String s: lstr1){
            System.out.println(s);
        }
        List<Integer> lstr2 = add(new Integer[]{1,2,3,4});
        //printing integers
        for(Integer s: lstr2){
            System.out.println(s);
        }
        List lstr = add1(strArray);
        //printing strings  non generic version
        for(Object o: lstr){
            String s = (String)o;
            System.out.println("non generic version: " + s);
        }
        /*List list = new ArrayList();

        list.add("Venkatram");
        list.add("200");
        list.add("44.44");
        list.add(123);

        for(Object o: list){
            String s = (String)o;
            System.out.println(s);
        }

        Iterator iter = list.iterator();
        while(iter.hasNext()){
            String s = (String)iter.next();
            System.out.println(s);
        }*/

        /*List<String> list = new ArrayList<>();
        list.add("Venkatram");
        list.add("200");
        list.add("44.44");

        for(String s: list){
            System.out.println(s);
        }*/

        /*Number
                Integer, Double, Long,*/
        Integer i = new Integer(123);
        Number n1 = i;//covariant

        Number[] num2 = new Integer[]{1,2,3};//covariant



        Number n = new Integer(123); //
        n = new Double(5.5);

        //List<T>  is not a subtype of  List<S>  invariant

        List<Integer> ints = Arrays.asList(1,3,4);

        List<? extends Number> num = ints; //lower bound  ,

        List<Number> num1 = Arrays.asList(1,3,4);

        List<? super Integer> is = num1; //upper bound, contravariant

        //List<? extends Number> num = ints;




    }

}
