package com.venkat.thread.ex4;

import com.venkat.thread.util.TaskD;
import com.venkat.thread.util.TaskE;

public class ReturningValuesSecondWay {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        TaskE taskE1 = new TaskE(2,3, 400, new SumObserver("Task-1"));
        Thread t1 = new Thread(taskE1,"Thread-1");

        TaskE taskE2 = new TaskE(4,5, 300, new SumObserver("Task-2"));
        Thread t2 = new Thread(taskE2,"Thread-2");

        TaskE taskE3 = new TaskE(6,7, 100, new SumObserver("Task-3"));
        Thread t3 = new Thread(taskE3,"Thread-3");

        taskE1.start();
        taskE2.start();
        taskE3.start();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
