package com.venkat.thread.ex4;

import com.venkat.thread.util.NamedThreadImpl;
import com.venkat.thread.util.TaskC;
import com.venkat.thread.util.TaskD;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReturningValuesFirstWay {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        TaskD taskD1 = new TaskD(2,3, 2000);
        Thread t1 = new Thread(taskD1,"Thread-1");

        TaskD taskD2 = new TaskD(4,5, 3000);
        Thread t2 = new Thread(taskD2,"Thread-2");

        TaskD taskD3 = new TaskD(6,7, 4000);
        Thread t3 = new Thread(taskD3,"Thread-3");

        taskD1.start();
        taskD2.start();
        taskD3.start();

        System.out.println("Result-1 = "+ taskD1.getSum());
        System.out.println("Result-2 = "+ taskD2.getSum());
        System.out.println("Result-3 = "+ taskD3.getSum());

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
