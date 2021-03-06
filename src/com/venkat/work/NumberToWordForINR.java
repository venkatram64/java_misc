package com.venkat.work;

import java.util.Scanner;

/**
 * Created by Venkatram on 2/24/2017.
 */
public class NumberToWordForINR {

    private static final String[] specialNames = {
            "",
            " hundred",
            " thousand",
            " lakh",
            " crore"
    };

    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    private String convertLessThanOneThousand(int number){
        String current = "";

        if(!(number % 100 < 20)){
            current = numNames[number % 10];
            number /= 10;

            current = tensNames[number % 10] + current;
        }else{
            current = numNames[number % 100];
            number /= 100;

        }

        if(number == 0){
            return current;
        }

        return numNames[number]  + current;
    }

    public String convert(int number){

        if(number == 0){
            return "zero";
        }

        String prefix = "";

        if(number < 0){
            number = - number;
            prefix = "negative";
        }

        String current = "";
        int place = 0;

        do{
            int n = number % 10;
            if(n != 0){
                String s = convertLessThanOneThousand(n);
                current = s + specialNames[place] + current;
            }
            place++;
            number /= 10;
        }while(number > 0);
        return (prefix + current).trim();
    }

    public static void main(String[] args) {
        System.out.println("Please Enter a number ");
        Scanner s = new Scanner(System.in);

        int number = s.nextInt();

        NumberToWordForINR con = new NumberToWordForINR();
        System.out.println(con.convert(number));
    }
}
