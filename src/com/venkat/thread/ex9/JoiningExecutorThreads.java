package com.venkat.thread.ex9;

import com.venkat.thread.util.NamedThreadImpl;
import com.venkat.thread.util.TaskCC;
import com.venkat.thread.util.TaskF;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JoiningExecutorThreads {

    public static void main(String[] args) {

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadImpl());

        CountDownLatch countDownLatch = new CountDownLatch(4);

        executorService.execute(new TaskCC(countDownLatch));
        executorService.execute(new TaskCC(countDownLatch));
        executorService.execute(new TaskCC(countDownLatch));
        executorService.execute(new TaskCC(countDownLatch));

        executorService.shutdown();
        try{
            countDownLatch.await();
            System.out.println("[" + currentThreadName + "] Got the signal to continue...");
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
