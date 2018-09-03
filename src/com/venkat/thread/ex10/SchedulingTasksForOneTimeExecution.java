package com.venkat.thread.ex10;

import com.venkat.thread.util.ScheduledTaskA;
import com.venkat.thread.util.TimerUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class SchedulingTasksForOneTimeExecution {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:ss.SSS");

    public static void main(String[] args) throws InterruptedException{

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        //Timer timer = new Timer("Timer-Thread ", false);
        Timer timer = new Timer("Timer-Thread ", true);
        Date currentTime = new Date();
        Date scheduledTime = TimerUtils.getFutureTime(currentTime, 5000);

        System.out.println("[" + currentThreadName + "] Current time: " + dateFormat.format(currentTime));

        timer.schedule(new ScheduledTaskA(0),scheduledTime);

        System.out.println("[" + currentThreadName + "] Task-1 scheduled for running at SPECIFIED TIME " +
                dateFormat.format(scheduledTime));

        //*********************************************************************//

        long delayMillis = 10000;
        ScheduledTaskA task2 = new ScheduledTaskA(0);
        timer.schedule(task2,delayMillis);

        System.out.println("[" + currentThreadName + "] Task-2 scheduled to run " +
               + delayMillis/1000 + " seconds INITIAL DELAY after current time i.e at at "
                +  dateFormat.format(new Date(task2.scheduledExecutionTime())));

        //*********************************************************************//

        long delayMillis2 = 15000;
        ScheduledTaskA task3 = new ScheduledTaskA(0);
        timer.schedule(task3,delayMillis2);

        System.out.println("[" + currentThreadName + "] Task-3 scheduled to run " +
                + delayMillis/1000 + " seconds INITIAL DELAY after current time i.e at at "
                +  dateFormat.format(new Date(task3.scheduledExecutionTime())));

        //*********************************************************************//

        Date sheduledTime2 = TimerUtils.getFutureTime(currentTime,40000);
        ScheduledTaskA task4 = new ScheduledTaskA(0);
        timer.schedule(task4,sheduledTime2);

        System.out.println("[" + currentThreadName + "] Task-4 scheduled for running at SPECIFIED TIME " +
                dateFormat.format(new Date(task4.scheduledExecutionTime())));

        //*********************************************************************//
        TimeUnit.MILLISECONDS.sleep((70000));
        System.out.println("[" + currentThreadName + "] CANCELLING THE TIMER NOW.");
        timer.cancel();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
