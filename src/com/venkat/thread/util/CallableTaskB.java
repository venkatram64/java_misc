package com.venkat.thread.util;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTaskB implements Callable<TaskResult<String, Integer>> {

    private int a;
    private int b;
    private long sleepTime;
    private int sum;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;


    public CallableTaskB(int a, int b, long sleepTime){
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "CalcTaskB-"+instanceNumber;
    }

    @Override
    public TaskResult<String, Integer> call() throws Exception{
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("### [" + currentThreadName + "]<" + taskId + ">STARTING #####");
        System.out.println("### [" + currentThreadName + "]<" + taskId + ">Sleeping for " + sleepTime + " millis");
        TimeUnit.MILLISECONDS.sleep(sleepTime);

        sum = a + b;
        System.out.println("*** [" + currentThreadName + "]<" + taskId + ">DONE *****");

        return new TaskResult<>(taskId,sum);
    }

}
