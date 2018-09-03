package com.venkat.thread.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskB implements Runnable {

    private long sleepTime;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:ss.SSS");
    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public ScheduledTaskB(long sleepTime){
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "ScheduledTaskB-"+instanceNumber;
    }

    @Override
    public void run() {
        Date startTime = new Date();

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("### [" + currentThreadName + "]<" + taskId + "> STARTED AT : " +
                        dateFormat.format(startTime) + " ######");
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("*** [" + currentThreadName + "]<" + taskId + "> FINISHED AT:" +
                            dateFormat.format(startTime) + " ######");

    }



}
