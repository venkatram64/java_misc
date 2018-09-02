package com.venkat.thread.util;

import java.util.concurrent.TimeUnit;

public class TaskDD extends Thread {

    private int a;
    private int b;
    private long sleepTime;
    private int sum;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public TaskDD(int a, int b, long sleepTime){
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "TaskD-"+instanceNumber;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("### [" + currentThreadName + "]<" + taskId + ">STARTING #####");
        System.out.println("### [" + currentThreadName + "]<" + taskId + ">Sleeping for " + sleepTime + " millis");
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum = a + b;

        System.out.println("*** [" + currentThreadName + "]<" + taskId + ">DONE *****");


        synchronized (this){
            System.out.println("[" + Thread.currentThread().getName() + "] ******* NOTIFIED");
            this.notify();
        }
    }

    public int getSum(){
        return sum;
    }

}
