package com.venkat.thread.ex7;

import com.venkat.thread.util.ExceptionLeakingTask;
import com.venkat.thread.util.ThreadExceptionHandler;

public class HandlingUncaughtExceptionsPerThread {

    public static void main(String[] args) throws Exception{
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Thread t1 = new Thread(new ExceptionLeakingTask(), "MyThread-1");
        t1.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        Thread t2 = new Thread(new ExceptionLeakingTask(), "MyThread-2");
        t2.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        Thread t3 = new Thread(new ExceptionLeakingTask(), "MyThread-3");
        t3.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        Thread t4 = new Thread(new ExceptionLeakingTask(), "MyThread-4");
        t4.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
