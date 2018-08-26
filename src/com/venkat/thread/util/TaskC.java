package com.venkat.thread.util;

import java.util.concurrent.TimeUnit;

public class TaskC implements Runnable {

    private static int count = 0;
    private int id;
    private String taskName ;

    @Override
    public void run() {
        //String currentThreadName = Thread.currentThread().getName();
        //System.out.println("#####["+currentThreadName +"]<" + this.taskName + "> Starting... ");
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
        //System.out.println("*****["+currentThreadName +"]<" + this.taskName + "> Ending... ");
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Ending... ");
    }

    public TaskC(){
        this.id = ++count;
        this.taskName = "TaskC-" + id;
    }
}
