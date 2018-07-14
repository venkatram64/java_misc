package com.venkat.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Venkatram on 2/23/2017.
 */
public class LambdaFeatures {

    public static int totalValues(List<Integer> values, Predicate<Integer> selector){
        /*int result = 0;
        for(int e : values){
            if(selector.test(e)){
                result += e;
            }
        }
        return result;*/

        return values.stream()
                .filter(selector)
                .reduce(0, Integer::sum);
    }

    public static void doWork(int value, Function<Integer, Integer> func){
        System.out.println(func.apply(value));
    }

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(totalValues(numbers, e->true));
        System.out.println(totalValues(numbers, e->e % 2 == 0));
        System.out.println(totalValues(numbers, e->e % 2 != 0));
        //
        Function<Integer, Integer> inc = e->e+1;
        Function<Integer, Integer> doubleIt = e->e*2;
        doWork(5, inc);
        doWork(5, doubleIt);
        doWork(5, inc.andThen(doubleIt));
    }
}
