package com.venkat.thread.ex4;


import com.venkat.thread.util.*;

import java.util.concurrent.*;

public class ReturningValuesUsingExecutorsThirdWay {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadImpl());

        CompletionService<TaskResult<String,Integer>> tasks = new ExecutorCompletionService<>(executorService);

        tasks.submit(new CallableTaskB(2,3,2000));
        tasks.submit(new CallableTaskB(4,5,2000));
        tasks.submit(new CallableTaskB(6,7,2000));

        tasks.submit(new TaskA(),new TaskResult<>("TaskA-1", 1234));
        for(int i = 0; i < 4; i++) {
            try {
                System.out.println(tasks.take().get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
