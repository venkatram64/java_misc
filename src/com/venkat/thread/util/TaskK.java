package com.venkat.thread.util;

import java.util.concurrent.TimeUnit;

public class TaskK implements Runnable {

    private static int count = 0;
    private int id;
    private String taskName ;
    private boolean sleepingInterruped;


    @Override
    public void run() {
        System.out.println("#####["+Thread.currentThread().getName() +"]<" + this.taskName + "> Starting... ");
        for(int i = 0;; i++){
            System.out.println("["+Thread.currentThread().getName() +"]<" + this.taskName + ">Tick Tick " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Sleep Interrupted, flag setting... ");
                sleepingInterruped = true;
            }

            doSomemoreWork();
            if(sleepingInterruped || Thread.interrupted()){
                System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Sleep Interrupted, Cancelling... ");
                break;
            }

        }
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Ending... ");
    }

    private void doSomemoreWork(){
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> DOING SOME MORE WORK... ");
    }

    public TaskK(){
        this.id = ++count;
        this.taskName = "TaskK-" + id;
    }
}
