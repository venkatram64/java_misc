package com.venkat.thread.ex4;


import com.venkat.thread.util.CallableTaskA;
import com.venkat.thread.util.NamedThreadImpl;
import com.venkat.thread.util.TaskA;

import java.util.concurrent.*;

public class ReturningValuesUsingExecutorsSecondWay {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadImpl());

        CompletionService<Integer> tasks = new ExecutorCompletionService<>(executorService);

        tasks.submit(new CallableTaskA(2,3,2000));
        tasks.submit(new CallableTaskA(4,5,2000));
        tasks.submit(new CallableTaskA(6,7,2000));

        tasks.submit(new TaskA(),1234);
        for(int i = 0; i < 4; i++) {
            try {
                System.out.println("Result-1 = " + tasks.take().get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
