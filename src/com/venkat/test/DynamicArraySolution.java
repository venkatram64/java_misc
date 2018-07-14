package com.venkat.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Venkatram on 3/7/2017.
 */
public class DynamicArraySolution {
    /*
        2 5
        1 0 5
        1 1 7
        1 0 3
        2 1 0
        2 1 1
    */
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int lastAns = 0;
        int nS = input.nextInt(); // # of sequence
        int nQ = input.nextInt(); // # of queries
        int type, x, y, index;

        ArrayList<Integer>[] seqList = new ArrayList[nS]; //array of arraylists of size # sequences

        // for each query...

        while(nQ-- > 0){
            //collect data from earch row
            type = input.nextInt(); //type of query 1 or 2
            x = input.nextInt(); // x value
            y = input.nextInt(); // y value
            index = (x ^ lastAns) % nS;

            switch (type){
                case 1:
                    //arraylist is populated with value y
                    if(seqList[index] == null){
                        ArrayList<Integer> myList = new ArrayList<>();
                        myList.add(y);
                        seqList[index] = myList;
                    }else{
                        seqList[index].add(y);
                    }
                    break;

                case 2:
                    //find the value at (y%size) and set lastAns equal to it
                    lastAns = seqList[index].get(y % seqList[index].size());
                    System.out.println(lastAns);
                    break;
            }
        }
    }
}
