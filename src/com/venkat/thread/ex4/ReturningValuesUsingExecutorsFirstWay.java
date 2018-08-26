package com.venkat.thread.ex4;


import com.venkat.thread.util.CallableTaskA;
import com.venkat.thread.util.NamedThreadImpl;
import com.venkat.thread.util.TaskA;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturningValuesUsingExecutorsFirstWay {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadImpl());
        Future<Integer> result1 = executorService.submit(new CallableTaskA(2,3,2000));
        Future<Integer> result2 = executorService.submit(new CallableTaskA(4,5,2000));
        Future<Integer> result3 = executorService.submit(new CallableTaskA(6,7,2000));

        Future<?> result4 = executorService.submit(new TaskA());
        Future<Double> result5 = executorService.submit(new TaskA(),1234.87);

        try {
            System.out.println("Result-1 = " + result1.get());
            System.out.println("Result-2 = " + result2.get());
            System.out.println("Result-3 = " + result3.get());
            System.out.println("Result-4 = " + result4.get());
            System.out.println("Result-5 = " + result5.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
