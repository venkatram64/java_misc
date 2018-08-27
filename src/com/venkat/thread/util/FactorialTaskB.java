package com.venkat.thread.util;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialTaskB implements Callable<Long> {

    private static int count = 0;
    private int id;
    private String taskName ;


    private long a;
    private long sleepTime;
    private long factorial;

    @Override
    public Long call() {
        System.out.println("#####["+Thread.currentThread().getName() +"]<" + this.taskName + "> Starting... ");
        factorial = 1L;

        for(long i = 1; i < a; i++){
            factorial *= i;
            System.out.println("["+Thread.currentThread().getName() +"]<" + this.taskName + ">Iteration " + i +
                    ". Intermediate Result = " + factorial);

            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Sleep interrupted properly... ");
                factorial = -1L;
                break;
            }

        }
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Ending... ");
        return factorial;
    }

    public FactorialTaskB(long a, long sleepTime){
        this.a = a;
        this.sleepTime = sleepTime;

        this.id = ++count;
        this.taskName = "FactorialTaskB-" + id;
    }
}
