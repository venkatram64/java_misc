package com.venkat.thread.ex3;

import com.venkat.thread.util.TaskB;
import com.venkat.thread.util.TaskC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NamingThreadsSecondWay {
    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("["+ currentThreadName+ "]Main thread starts here...");

        new Thread(new TaskC(),"MyTaskC-1").start();
        Thread t2 = new Thread(new TaskC());
        //t2.setName("MyTaskC-2");
        t2.start();
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //after starting the thread, rename the thread
        t2.setName("MyTaskC-2");
        System.out.println("["+ currentThreadName+ "]Main thread ends here...");
    }
}
