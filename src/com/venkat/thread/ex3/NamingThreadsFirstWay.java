package com.venkat.thread.ex3;

import com.venkat.thread.util.TaskB;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingThreadsFirstWay {
    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("["+ currentThreadName+ "]Main thread starts here...");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new TaskB());
        executorService.execute(new TaskB());
        executorService.execute(new TaskB());



        executorService.shutdown();
        System.out.println("["+ currentThreadName+ "]Main thread ends here...");
    }
}
