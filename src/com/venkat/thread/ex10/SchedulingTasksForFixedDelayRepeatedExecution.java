package com.venkat.thread.ex10;

import com.venkat.thread.util.ScheduledTaskA;
import com.venkat.thread.util.TimerUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class SchedulingTasksForFixedDelayRepeatedExecution {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:ss.SSS");

    public static void main(String[] args) throws InterruptedException{

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Timer timer = new Timer("Timer-Thread ", true);
        Date currentTime = new Date();

        System.out.println("[" + currentThreadName + "] Current time: " + dateFormat.format(currentTime));

        Date scheduledTime = TimerUtils.getFutureTime(currentTime, 3000);

        long intervalMillis = 2000;

        timer.schedule(new ScheduledTaskA(1000),scheduledTime, intervalMillis);

        System.out.println("[" + currentThreadName + "] Task-1 scheduled for " +
                dateFormat.format(scheduledTime) + " and then repeatedly at an interval of every " + intervalMillis/1000 + " seconds!");

        long delaylMillis = 4000;
        long intervalMillis2 = 2000;

        timer.schedule(new ScheduledTaskA(1000),delaylMillis, intervalMillis2);

        System.out.println("[" + currentThreadName + "] Task-2 scheduled for " + delaylMillis/1000 +
               " seconds after " + dateFormat.format(currentTime) + " and then repeatedly at an interval of every "
                + intervalMillis2/1000 + " seconds!");

        TimeUnit.MILLISECONDS.sleep(16000);

        System.out.println("[" + currentThreadName + "] CANCELLING THE NOW... " );
        timer.cancel();
        //*********************************************************************//


        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
