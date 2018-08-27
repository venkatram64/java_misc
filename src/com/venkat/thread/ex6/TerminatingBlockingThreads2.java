package com.venkat.thread.ex6;


import com.venkat.thread.util.TaskK;
import com.venkat.thread.util.TaskK;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TerminatingBlockingThreads2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        TaskK taskK = new TaskK();
        TaskK taskK1 = new TaskK();
        TaskK taskK2 = new TaskK();

        Thread t1 = new Thread(taskK, "MyThread-1");
        t1.start();

        Thread t2 = new Thread(taskK1, "MyThread-2");
        t2.start();

        Thread t3 = new Thread(taskK2, "MyThread-3");
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
