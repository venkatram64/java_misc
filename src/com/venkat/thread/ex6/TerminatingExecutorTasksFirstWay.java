package com.venkat.thread.ex6;


import com.venkat.thread.util.FactorialTaskA;
import com.venkat.thread.util.NamedThreadImpl;
import com.venkat.thread.util.TaskG;
import com.venkat.thread.util.TaskK;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TerminatingExecutorTasksFirstWay {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadImpl());
        FactorialTaskA task = new FactorialTaskA(30, 1000);

        TaskG task2 = new TaskG();

        executorService.execute(task2);
        executorService.submit(task);
        executorService.shutdown();

        TimeUnit.MILLISECONDS.sleep(3000);
        task.cancel();
        task2.cancel();
        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
