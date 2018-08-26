package com.venkat.thread.util;

import java.util.concurrent.TimeUnit;

public class TaskE extends Thread {

    private int a;
    private int b;
    private long sleepTime;
    private int sum;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    ResultNotifier<Integer> listener;

    public TaskE(int a, int b, long sleepTime, ResultNotifier<Integer> listener){
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.listener = listener;

        this.instanceNumber = ++count;
        this.taskId = "TaskE-"+instanceNumber;
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
        listener.notifyResult(sum);
    }

}
