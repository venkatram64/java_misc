package com.venkat.thread.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class CalcTaskA implements Callable<Long> {

    private static int count = 0;
    private int id;
    private String taskName ;

    private volatile boolean isThreadInterrupted = false;

    private final int Data_SIZE = 100000;

    @Override
    public Long call() throws Exception{
        System.out.println("#####["+Thread.currentThread().getName() +"]<" + this.taskName + "> Starting... ");
        long totalTimeTakenInMillis = 0;
        for(int i = 0; i< 1000; i++){
            System.out.println("["+Thread.currentThread().getName() +"]<" + this.taskName + ">CURRENT RUNNING AVERAGE = " +
                    (i == 0 ? 0 : totalTimeTakenInMillis/(2 * i)));
            long timeTakenInMillis = doSomeWork();
            totalTimeTakenInMillis += timeTakenInMillis;

            if(Thread.interrupted()){
                System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> interrupted, Cancelling... ");
                isThreadInterrupted = true;
                break;
            }
        }
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> interrupted, status ... "
                + Thread.interrupted());
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Ending... ");

        return isThreadInterrupted ? -1L : totalTimeTakenInMillis /(2 * 1000);
    }

    private long doSomeWork(){

        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 2; i ++){
            Collections.sort(generateDataSet());
        }
        return System.currentTimeMillis() - startTime;
    }

    private List<Integer> generateDataSet(){
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < Data_SIZE; i++){
            list.add(random.nextInt(Data_SIZE));
        }
        return list;
    }

    public CalcTaskA(){
        this.id = ++count;
        this.taskName = "CalcTaskA-" + id;
    }
}
