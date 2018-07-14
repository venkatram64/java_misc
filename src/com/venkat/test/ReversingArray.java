package com.venkat.test;

import java.util.Scanner;

/**
 * Created by Venkatram on 3/6/2017.
 */
public class ReversingArray {

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void reverseOrder(int[] arr){
        for(int i = 0; i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;

        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }

    public static void hourGlass(){
        /* hour glass should be
        1 1 1   1 1 0   1 0 0   0 0 0
          1       0       0       0
        1 1 1   1 1 0   1 0 0   0 0 0

        0 1 0   1 0 0   0 0 0   0 0 0
          1       1       0       0
        0 0 2   0 2 4   2 4 4   4 4 0

        1 1 1   1 1 0   1 0 0   0 0 0
          0       2       4       4
        0 0 0   0 0 2   0 2 0   2 0 0

        0 0 2   0 2 4   2 4 4   4 4 0
          0       0       2       0
        0 0 1   0 1 2   1 2 4   2 4 0
         */
        int[][] arr = new int[6][6];
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 6; i++){
            String[] tmp = in.nextLine().split(" ");
            int j = 0;
            for(String s: tmp){
                arr[i][j++] = Integer.parseInt(s);
            }
        }

        int low = -9, high = 5;
        int lh = low * high;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                int sum=arr[i][j]+arr[i][j+1]+arr[i][j+2]
                        +arr[i+1][j+1]
                        +arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                lh = Math.max(lh,sum);
            }
        }
        System.out.println(lh);
    }

    public static void main(String[] args){
        /*int[] arr = {1,2,3,4};
        reverseOrder(arr);*/
        hourGlass();
        /*   -9 <= A[I][J] <= 9    0<=I,J<=5
        1 1 1 0 0 0
        0 1 0 0 0 0
        1 1 1 0 0 0
        0 0 2 4 4 0
        0 0 0 2 0 0
        0 0 1 2 4 0
         */
    }
}
