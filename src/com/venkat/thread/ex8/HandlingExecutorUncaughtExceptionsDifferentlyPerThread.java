package com.venkat.thread.ex8;

import com.venkat.thread.util.ExceptionLeakingTask;
import com.venkat.thread.util.ThreadExceptionHandler;
import com.venkat.thread.util.ThreadFactoryWithExcepionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorUncaughtExceptionsDifferentlyPerThread {

    public static void main(String[] args) throws Exception{
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryWithExcepionHandler());
        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
