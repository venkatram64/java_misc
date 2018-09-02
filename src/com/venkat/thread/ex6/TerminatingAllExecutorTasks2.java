package com.venkat.thread.ex6;


import com.venkat.thread.util.*;

import java.util.concurrent.*;

public class TerminatingAllExecutorTasks2 {

    public static void main(String[] args) throws Exception{
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newFixedThreadPool(2,new NamedThreadImpl());
        FactorialTaskB task = new FactorialTaskB(30,500);

        TaskA task2 = new TaskA();
        TaskH task3 = new TaskH();

        CallableTaskB task4 = new CallableTaskB(2,3,9000);

        Future<?> t2 = executorService.submit(task2);
        Future<Long> t = executorService.submit(task);
        Future<?> t3 = executorService.submit(task3);
        Future<TaskResult<String, Integer>> t4 = executorService.submit(task4);


        TimeUnit.MILLISECONDS.sleep(1000);

        executorService.shutdownNow();

        System.out.println("[" + currentThreadName + "] All Threads Terminated..." +
                executorService.awaitTermination(5000,TimeUnit.MILLISECONDS));

        System.out.println("[" + currentThreadName + "] FactorialTaskB-1, result = " + t.get());
        System.out.println("[" + currentThreadName + "] TaskH-1, result = " + t3.get());
        System.out.println("[" + currentThreadName + "] CallableTaskB, result = " + t4.get());

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
}
}
