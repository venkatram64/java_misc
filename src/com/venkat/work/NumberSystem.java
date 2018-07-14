package com.venkat.work;

import java.util.Scanner;

/**
 * Created by Venkatram on 2/24/2017.
 */
public class NumberSystem {

    public static String convertIntoWords(int number){
        String[] word = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String answer = "";
        int temp = number;
        while(number != 0){
            int digit = number % 10;
            answer = word[digit] + " " + answer;
            number = number / 10;
        }
        return answer.trim();
    }

    public static void main(String[] args){
        System.out.println("Enter a number ");
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();

        System.out.println(convertIntoWords(number));
    }
}
