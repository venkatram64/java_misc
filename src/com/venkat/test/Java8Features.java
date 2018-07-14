package com.venkat.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Venkatram on 3/10/2017.
 */
public class Java8Features {

    public static void featureOne(){
        List<String> strs = Arrays.asList("john", "John", "Lisa","Alice");
        /*Collections.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });*/

        Collections.sort(strs, (s1, s2) -> s1.compareToIgnoreCase(s2));

        for(String s : strs){
            System.out.printf("%s ", s);
        }
    }

    public static void main(String[] args){
        featureOne();
    }
}
