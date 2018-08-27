package com.venkat.thread.ex6;


import com.venkat.thread.util.*;

import java.util.concurrent.*;

public class TerminatingExecutorTasksSecondWay {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadImpl());
        CalcTaskA task = new CalcTaskA();

        TaskH task2 = new TaskH();

        Future<?> f = executorService.submit(task2);
        Future<Long> f1 = executorService.submit(task);

        executorService.shutdown();

        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("[" + currentThreadName + "] Interrupting TaskG...");
        f.cancel(true);
        System.out.println("[" + currentThreadName + "] Interrupting CalcTaskA...");
        f1.cancel(true);
        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
