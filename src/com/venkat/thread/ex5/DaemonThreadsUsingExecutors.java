package com.venkat.thread.ex5;


import com.venkat.thread.util.DaemonThreadImpl;
import com.venkat.thread.util.TaskF;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreadsUsingExecutors {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadImpl());
        executorService.execute(new TaskF(100));
        executorService.execute(new TaskF(200));
        executorService.execute(new TaskF(100));
        executorService.execute(new TaskF(200));

        executorService.shutdown();


        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
