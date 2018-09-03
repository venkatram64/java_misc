package com.venkat.thread.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculateTaskD implements Callable<Integer> {

    private int a;
    private int b;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:ss.SSS");

    public CalculateTaskD(int a, int b, long sleepTime){
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "CalculateTaskD-"+instanceNumber;
    }

    @Override
    public Integer call() throws Exception{

        Date startTime = new Date();
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("### [" + currentThreadName + "]<" + taskId + ">STARTED at "
            + dateFormat.format(startTime) + " ###### ");


        TimeUnit.MILLISECONDS.sleep(sleepTime);

        System.out.println("### [" + currentThreadName + "]<" + taskId + "> FINISHED at " +
                dateFormat.format(new Date()) + " ***** ");

        return a + b;
    }

}
