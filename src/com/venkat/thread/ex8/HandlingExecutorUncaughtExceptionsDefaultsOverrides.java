package com.venkat.thread.ex8;

import com.venkat.thread.util.ExceptionLeakingTask;
import com.venkat.thread.util.ThreadExceptionHandler;
import com.venkat.thread.util.ThreadFactoryWithExcepionHandler;
import com.venkat.thread.util.ThreadFactoryWithExcepionHandlerAlternator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorUncaughtExceptionsDefaultsOverrides {

    public static void main(String[] args) throws Exception{
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER_ONE"));

        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryWithExcepionHandlerAlternator());
        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
