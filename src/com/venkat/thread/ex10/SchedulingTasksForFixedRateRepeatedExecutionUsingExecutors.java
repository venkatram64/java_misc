package com.venkat.thread.ex10;

import com.venkat.thread.util.NamedThreadImpl;
import com.venkat.thread.util.ScheduledTaskB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulingTasksForFixedRateRepeatedExecutionUsingExecutors {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:ss.SSS");

    public static void main(String[] args) throws Exception{

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3,new NamedThreadImpl());

        System.out.println("[" + currentThreadName + "] Current time " + dateFormat.format(new Date()));

        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(new ScheduledTaskB(1000),4, 2, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture2 = executorService.scheduleAtFixedRate(new ScheduledTaskB(3000),4, 2, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(15000);

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
