package com.venkat.thread.ex6;


import com.venkat.thread.util.TaskJ;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TerminatingBlockingThreads {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        TaskJ taskJ = new TaskJ();
        TaskJ taskJ1 = new TaskJ();
        TaskJ taskJ2 = new TaskJ();

        Thread t1 = new Thread(taskJ, "MyThread-1");
        t1.start();

        Thread t2 = new Thread(taskJ1, "MyThread-2");
        t2.start();

        Thread t3 = new Thread(taskJ2, "MyThread-3");
        t3.start();

        TimeUnit.MILLISECONDS.sleep(3000);

        System.out.println("[" + currentThreadName + "] Main thread INTERRUPTING..." + t1.getName());
        t1.interrupt();

        System.out.println("[" + currentThreadName + "] Main thread INTERRUPTING..." + t2.getName());
        t2.interrupt();

        System.out.println("[" + currentThreadName + "] Main thread INTERRUPTING..." + t3.getName());
        t3.interrupt();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
