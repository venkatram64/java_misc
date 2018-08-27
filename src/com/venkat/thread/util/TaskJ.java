package com.venkat.thread.util;

import java.util.concurrent.TimeUnit;

public class TaskJ implements Runnable {

    private static int count = 0;
    private int id;
    private String taskName ;


    @Override
    public void run() {
        System.out.println("#####["+Thread.currentThread().getName() +"]<" + this.taskName + "> Starting... ");
        for(int i = 0;; i++){
            System.out.println("["+Thread.currentThread().getName() +"]<" + this.taskName + ">Tick Tick " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Sleep Interrupted, Cancelling... ");
                break;
            }

        }
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Ending... ");
    }



    public TaskJ(){
        this.id = ++count;
        this.taskName = "TaskJ-" + id;
    }
}
