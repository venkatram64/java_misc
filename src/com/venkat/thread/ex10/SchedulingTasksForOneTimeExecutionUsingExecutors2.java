package com.venkat.thread.ex10;

import com.venkat.thread.util.CalculateTaskD;
import com.venkat.thread.util.NamedThreadImpl;
import com.venkat.thread.util.ScheduledTaskB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulingTasksForOneTimeExecutionUsingExecutors2 {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:ss.SSS");

    public static void main(String[] args) throws Exception{

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3, new NamedThreadImpl());

        System.out.println("[" + currentThreadName + "] Current time " + dateFormat.format(new Date()));

        ScheduledFuture<?> scheduledFuture = executorService.schedule(new ScheduledTaskB(3000),4, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture2 = executorService.schedule(new CalculateTaskD(2,3,3000),6, TimeUnit.SECONDS);

        executorService.schedule(new ScheduledTaskB(0),8,TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture3 = executorService.schedule(new CalculateTaskD(3,4,0),10, TimeUnit.SECONDS);

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] RETURNING THE RESULTS NOW ...");

        System.out.println("[" + currentThreadName + "] TASK-1 = " + scheduledFuture.get());
        System.out.println("[" + currentThreadName + "] TASK-2 = " + scheduledFuture2.get());
        System.out.println("[" + currentThreadName + "] TASK-3 = " + scheduledFuture3.get());


        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
