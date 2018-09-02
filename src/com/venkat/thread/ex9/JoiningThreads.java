package com.venkat.thread.ex9;

import com.venkat.thread.util.ExceptionLeakingTask;
import com.venkat.thread.util.TaskF;
import com.venkat.thread.util.ThreadExceptionHandler;
import com.venkat.thread.util.ThreadFactoryWithExcepionHandlerAlternator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JoiningThreads {

    public static void main(String[] args) throws InterruptedException{

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Thread t1 = new Thread(new TaskF(100),"MyThread-1");
        Thread t2 = new Thread(new TaskF(200),"MyThread-1");
        Thread t3 = new Thread(new TaskF(300),"MyThread-1");
        Thread t4 = new Thread(new TaskF(400),"MyThread-1");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        System.out.println("[" + currentThreadName + "] joined " + t1.getName());
        t2.join();
        System.out.println("[" + currentThreadName + "] joined " + t2.getName());
        t3.join();
        System.out.println("[" + currentThreadName + "] joined " + t3.getName());
        t4.join();
        System.out.println("[" + currentThreadName + "] joined " + t4.getName());

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
