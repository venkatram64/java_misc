package com.venkat.thread.ex6;


import com.venkat.thread.util.*;

import java.util.concurrent.*;

public class TerminatingBlockedExecutorTasks {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadImpl());
        FactorialTaskB task = new FactorialTaskB(30,500);

        TaskA task2 = new TaskA();
        TaskH task3 = new TaskH();

        Future<?> f = executorService.submit(task2);
        Future<Long> f1 = executorService.submit(task);
        Future<?> f2 = executorService.submit(task3);

        executorService.shutdown();

        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("[" + currentThreadName + "] Interrupting TaskG...");
        System.out.println("[" + currentThreadName + "] Cancelling  CalcTaskA = " + f.cancel(true));

        System.out.println("[" + currentThreadName + "] Interrupting CalcTaskA...");
        System.out.println("[" + currentThreadName + "] Cancelling  TaskG = " + f1.cancel(true));

        System.out.println("[" + currentThreadName + "] Interrupting TaskG...");
        System.out.println("[" + currentThreadName + "] Cancelling  TaskG2 = " + f2.cancel(true));

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
