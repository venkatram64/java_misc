package com.venkat.thread.ex2;

import com.venkat.thread.util.TaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolEx {

    public static void main(String[] args) {
        System.out.println("Main thread starts here...");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new TaskA());
        executorService.execute(new TaskA());
        executorService.execute(new TaskA());

        executorService.shutdown();
        System.out.println("Main thread ends here...");
    }
}
