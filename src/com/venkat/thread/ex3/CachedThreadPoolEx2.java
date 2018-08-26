package com.venkat.thread.ex3;

import com.venkat.thread.util.NamedThreadImpl;
import com.venkat.thread.util.TaskA;
import com.venkat.thread.util.TaskC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolEx2 {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadImpl());

        executorService.execute(new TaskC());
        executorService.execute(new TaskC());
        executorService.execute(new TaskC());

        TimeUnit.SECONDS.sleep(15);

        executorService.execute(new TaskC());
        executorService.execute(new TaskC());
        executorService.execute(new TaskC());
        executorService.execute(new TaskC());
        executorService.execute(new TaskC());

        executorService.shutdown();
        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
