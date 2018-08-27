package com.venkat.thread.util;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialTaskA implements Callable<Long> {

    private static int count = 0;
    private int id;
    private String taskName ;

    private volatile boolean shutdown = false;

    private long a;
    private long sleepTime;
    private long factorial;

    @Override
    public Long call() throws Exception{
        System.out.println("#####["+Thread.currentThread().getName() +"]<" + this.taskName + "> Starting... ");
        factorial = 1L;

        for(long i = 1; i < a; i++){
            factorial *= i;
            System.out.println("["+Thread.currentThread().getName() +"]<" + this.taskName + ">Iteration " + i +
                    ". Intermediate Result = " + factorial);

            TimeUnit.MILLISECONDS.sleep(sleepTime);

            synchronized (this) {
                if (this.shutdown) {
                    factorial = -1L;
                    break;
                }
            }
        }
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Ending... ");
        return factorial;
    }

    public void cancel(){
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Shutting down... ");
        synchronized (this){
            this.shutdown = true;
        }
    }

    public FactorialTaskA(long a, long sleepTime){
        this.a = a;
        this.sleepTime = sleepTime;

        this.id = ++count;
        this.taskName = "FactorialTaskA-" + id;
    }
}
