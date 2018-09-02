package com.venkat.thread.ex8;

import com.venkat.thread.util.ExceptionLeakingTask;
import com.venkat.thread.util.ThreadExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorUncaughtExceptionsForEveryThread {

    public static void main(String[] args) throws Exception{
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        ExecutorService executorService1 = Executors.newCachedThreadPool();
        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(new ExceptionLeakingTask());
        executorService2.execute(new ExceptionLeakingTask());
        executorService2.execute(new ExceptionLeakingTask());

        executorService1.shutdown();
        executorService2.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
