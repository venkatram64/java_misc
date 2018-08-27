package com.venkat.thread.util;

import java.util.concurrent.TimeUnit;

public class TaskG implements Runnable {

    private static int count = 0;
    private int id;
    private String taskName ;

    private volatile boolean shutdown = false;

    @Override
    public void run() {
        System.out.println("#####["+Thread.currentThread().getName() +"]<" + this.taskName + "> Starting... ");
        for(int i = 0;; i++){
            System.out.println("["+Thread.currentThread().getName() +"]<" + this.taskName + ">Tick Tick " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (this.shutdown) {
                    break;
                }
            }
        }
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Ending... ");
    }

    public void cancel(){
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Shutting down... ");
        synchronized (this){
            this.shutdown = true;
        }
    }

    public TaskG(){
        this.id = ++count;
        this.taskName = "TaskG-" + id;
    }
}
