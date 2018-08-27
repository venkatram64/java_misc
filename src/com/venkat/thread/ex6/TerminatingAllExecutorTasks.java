package com.venkat.thread.ex6;


import com.venkat.thread.util.*;

import java.util.concurrent.*;

public class TerminatingAllExecutorTasks {

    public static void main(String[] args) throws InterruptedException{
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newFixedThreadPool(2,new NamedThreadImpl());
        FactorialTaskB task = new FactorialTaskB(30,500);

        TaskA task2 = new TaskA();
        TaskH task3 = new TaskH();

        CallableTaskB task4 = new CallableTaskB(2,3,9000);

        executorService.submit(task2);
        executorService.submit(task);
        executorService.submit(task3);
        executorService.submit(task4);


        TimeUnit.MILLISECONDS.sleep(1000);

        executorService.shutdownNow();

        System.out.println("[" + currentThreadName + "] All Threads Terminated..." +
                executorService.awaitTermination(500,TimeUnit.MILLISECONDS));

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
