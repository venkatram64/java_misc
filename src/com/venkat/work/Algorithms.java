package com.venkat.work;

import java.util.Scanner;

/**
 * Created by Venkatram on 2/18/2017.
 */
public class Algorithms {

    public static void  swap(int x, int y){
        System.out.println("Before swap x and y are : " + x +"  " + y);
        x = x*y;
        y = x/y;
        x= x/y;
        System.out.println("After swap x and y are : " + x + "  " + y);
    }

    public static void  swapWithXOR(int x, int y){
        System.out.println("Before swap x and y are : " + x +"  " + y);
        x = x^y;
        y = x^y;
        x= x^y;
        System.out.println("After swap x and y are : " + x + "  " + y);
    }
    //reversing a number
    public static void reverse(){
        System.out.println("Enter a number ");
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();

        int rev = 0;

        while(number != 0){
            rev = rev * 10;
            rev += number%10;
            number = number / 10;
        }
        System.out.println("Reversed number is " + rev);
    }
    //reversing string
    public static void reverseString(){
        System.out.println("Enter a string ");

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        char[] inputChar = input.toCharArray();
        int left = 0, right = 0;
        right = inputChar.length - 1;

        for(left = 0; left < right; left++, right--){
            //swap values of left and right
            char temp = inputChar[left];
            inputChar[left] = inputChar[right];
            inputChar[right] = temp;
        }
        String reverseStr = String.valueOf(inputChar);
        System.out.println(reverseStr);
    }

    public static void main(String[] args){
        swap(4,5);
        swapWithXOR(7, 9);
        String s = "venkat";
        Object obj = null;
        int[] array = new int[10];
        int i = array.length;

        //reverse();
        reverseString();
    }
}
