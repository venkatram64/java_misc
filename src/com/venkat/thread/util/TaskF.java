package com.venkat.thread.util;

import java.util.concurrent.TimeUnit;

public class TaskF implements Runnable {

    private static int count = 0;
    private int id;
    private String taskName ;
    private long sleepTime;

    @Override
    public void run() {
        boolean isDaemonThread = Thread.currentThread().isDaemon();

        String threadType = isDaemonThread ? "Daemon" : "User";

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("#####["+currentThreadName +" " +threadType +"]<" + this.taskName + "> Starting... ");
        for(int i = 0; i<10; i++){
            System.out.println("["+currentThreadName +" " +threadType +"]<" + this.taskName + ">Tick Tick " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("*****["+currentThreadName +" " +threadType +" ]<" + this.taskName + "> Ending... ");
    }

    public TaskF(long sleepTime){

        this.sleepTime = sleepTime;
        this.id = ++count;
        this.taskName = "TaskF-" + id;
    }
}
