package com.venkat.thread.ex5;


import com.venkat.thread.util.*;

import java.util.concurrent.*;

public class ExecutorThreadIsAlive {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadImpl());

        Future<?> f1 = executorService.submit(new TaskA(),new TaskResult<>("TaskA-1", 1234));

        Future<Integer> f2 = executorService.submit(new CallableTaskA(2,3,500));

        FutureTask<?> ft = new FutureTask<Void>(new TaskA(), null);
        FutureTask<Integer> ft2 = new FutureTask<>(new TaskA(),234);
        FutureTask<Integer> ft3 = new FutureTask<>(new CallableTaskA(5,6,600));

        executorService.execute(ft);
        executorService.execute(ft2);
        executorService.execute(ft3);

        executorService.shutdown();

        for(int i = 0; i < 5; i++) {
            TimeUnit.MILLISECONDS.sleep(600);
            System.out.println("[" + currentThreadName + "]  TaskA  is alive " + f1.isDone());
            System.out.println("[" + currentThreadName + "]  CallableTaskA  is alive " + f2.isDone());
            System.out.println("[" + currentThreadName + "]  Future Task TaskA(null)  is alive " + ft.isDone());
            System.out.println("[" + currentThreadName + "]  Future Task TaskA  is alive " + ft2.isDone());
            System.out.println("[" + currentThreadName + "]  Future Task CallableTaskA  is alive " + ft3.isDone());
         }

        System.out.println("[" + currentThreadName + "] Retrieving results for TaskA..." + f1.get());
        System.out.println("[" + currentThreadName + "] Retrieving results for CallableTaskA..." + f2.get());

        System.out.println("[" + currentThreadName + "] Retrieving results for TaskA..." + ft.get());
        System.out.println("[" + currentThreadName + "] Retrieving results for TaskA..." + ft2.get());
        System.out.println("[" + currentThreadName + "] Retrieving results for CallableTaskA..." + ft3.get());

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
