package com.venkat.java8.stream;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Venkatram on 3/11/2017.
 */
public class FindingMaxLength {
    public static void main(String[] args){
        String[] info = {
          "This is test", "This is another test", "This is another test string", "This is yet another test string"
        };
        System.out.println(
        Arrays.stream(info)
                .max(Comparator.comparingInt(String :: length))
                .get()
        );
    }
}
