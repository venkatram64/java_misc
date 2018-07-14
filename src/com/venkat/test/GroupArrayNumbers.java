package com.venkat.test;

import java.util.Random;

/**
 * Created by Venkatram on 3/9/2017.
 */
public class GroupArrayNumbers {

    public static void print(int[] nums){
        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void rearrange(int[] array, int target){
        int last = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] < target){
                swap(array, i, last++);
            }
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /*
    3 -3 8 -8 -2 -4 4 7 2 8 -8 -9 -8 3 -5 8 4 7 -6 3
    -3 -8 -2 -4 -8 -9 -8 -5 -6 8 8 3 4 3 7 8 4 7 2 3
    */
    public static void main(String[] args){
        Random random = new Random();
        int[] nums = new int[20];
        for(int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(20) - 10;
        }
        print(nums);
        rearrange(nums, 0);
        print(nums);
    }
}
