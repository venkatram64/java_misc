package com.venkat.thread.ex10;

import com.venkat.thread.util.NamedThreadImpl;
import com.venkat.thread.util.ScheduledTaskB;
import com.venkat.thread.util.TimerUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulingTasksForFixedDelayRepeatedExecutionUsingExecutors3 {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:ss.SSS");

    public static void main(String[] args) throws Exception{

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadImpl());

        System.out.println("[" + currentThreadName + "] Current time " + dateFormat.format(new Date()));

        ScheduledFuture<?> scheduledFuture = executorService.scheduleWithFixedDelay(new ScheduledTaskB(1000),4, 2, TimeUnit.SECONDS);

        for(int i = 0; i < 10; i++){
            System.out.println("[" + currentThreadName + "] Next run of TASK-1 scheduled at approx. ");
            Date scheduledTime = TimerUtils.getFutureTime(new Date(), scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
            System.out.println(dateFormat.format(scheduledTime));

            TimeUnit.MILLISECONDS.sleep(3000);
        }

        //TimeUnit.MILLISECONDS.sleep(15000);

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
