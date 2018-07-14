package com.venkat.test;

import java.util.Scanner;

/**
 * Created by Venkatram on 3/7/2017.
 */
public class FibMemoization {
    static final long[] FM = new long[100];

    public static long fib(int n){
        if(n <= 1){
            return 1;
        }
        if(FM[n] != 0){
            return FM[n];
        }
        FM[n] = fib(n-1) + fib(n-2);
        return FM[n];

    }

    public static void main(String[] args){
        System.out.println("Enter a number for fib: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.print(fib(num) + "  ");
    }
}
