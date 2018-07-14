package com.venkat.java8.unit2;

import java.util.function.BiConsumer;

/**
 * Created by Venkatram on 3/10/2017.
 */
public class ExceptionTest {
    public static void main(String[] args){
        int[] numbers = {2,3,5,9};
        int key = 0;
        //process(numbers, key, (v,k)->System.out.println(v/k));
        //handling the exception best way is wirte a wrapper method, that
        //method will have the try, catch exception
        process(numbers, key, wrapperLambda((v,k)->System.out.println(v/k)));

    }
    public static void process(int[] numbers, int key,
                               BiConsumer<Integer, Integer> consumer){
        for(int i : numbers){
            consumer.accept(i, key);
        }
    }

    public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
        return (v, k) ->{
            try{
                consumer.accept(v, k);
            }catch (ArithmeticException e){
                System.out.println("Exception caught in wrapper lambda");
            }
        };
    }
}
