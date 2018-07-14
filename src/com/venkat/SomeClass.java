package com.venkat;

/**
 * Created by Venkatram on 5/6/2017.
 */
public class SomeClass {

    // find the sum of individual digits for giben number
    //12345 = > 1 + 2 + 3 + 4

    public int sumOfDigits(int number){

        int sum = 0;

        while(number > 0){
            sum = sum + number%10; // sum = 9 + 1
            number = number /10;    //number = 1234/10 => 123 =>123/10 =>12 => 12/10 =>1 => 1/10 => 0
        }
        return sum;

    }

    public static void oneD(){
        int[] j = new int[]{1,2,3};
        for(int i = 0; i < j.length; i++){
            System.out.println(i);
        }

        for (int i : j){
            System.out.println(i);
        }
    }

    public static void twoD(){
        int[][] arr = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void threeD(){
        int[][][] arr = new int[][][]{
                {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
                },
                {
                    {-1, -2, -3},
                    {-4, -5, -6},
                    {-7, -8, -9}
                }
        };
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        SomeClass sc = new SomeClass();
        System.out.println(sc.sumOfDigits(1234));
        //twoD();
        threeD();
    }
}
