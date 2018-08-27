package com.venkat.thread.ex6;


import com.venkat.thread.util.*;

import java.util.concurrent.*;

public class TerminatingThreadsFirstWay {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        TaskG taskG = new TaskG();
        TaskG taskG1 = new TaskG();
        TaskG taskG2 = new TaskG();

        new Thread(taskG, "MyThread-1").start();
        new Thread(taskG1, "MyThread-2").start();
        new Thread(taskG2, "MyThread-3").start();

        TimeUnit.MILLISECONDS.sleep(5000);
        taskG.cancel();
        taskG1.cancel();
        taskG2.cancel();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
