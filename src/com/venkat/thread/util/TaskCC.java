package com.venkat.thread.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TaskCC implements Runnable {

    private static int count = 0;
    private int id;
    private String taskName ;

    private CountDownLatch countDownLatch;

    @Override
    public void run() {
        System.out.println("#####["+Thread.currentThread().getName() +"]<" + this.taskName + "> Starting... ");
        for(int i = 0; i<10; i++){
            //System.out.println("["+currentThreadName +"]<" + this.taskName + ">Tick Tick " + i);
            System.out.println("["+Thread.currentThread().getName() +"]<" + this.taskName + ">Tick Tick " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Ending... ");

        if(countDownLatch != null){
            countDownLatch.countDown();
            System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> " +
                    "Latch Count = " + countDownLatch.getCount());
        }
    }

    public TaskCC(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
        this.id = ++count;
        this.taskName = "TaskCC-" + id;
    }
}
