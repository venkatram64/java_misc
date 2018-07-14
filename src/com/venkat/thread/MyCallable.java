package com.venkat.thread;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by Venkatram on 3/15/2017.
 */
public class MyCallable {

    public static void myCallableInvokeAny(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callableSet = new HashSet<>();

        callableSet.add(()->{
            return "Task 1";
        });
        callableSet.add(()->{
            return "Task 2";
        });
        callableSet.add(()->{
            return "Task 2";
        });

        try {
            String result = executorService.invokeAny(callableSet);
            System.out.println("result = " + result);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void myCallableInvokeAll(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(()->{
            return "Task 1";
        });
        callables.add(()->{
            return "Task 2";
        });
        callables.add(()->{
            return "Task 2";
        });

        try {
            List<Future<String>> list = executorService.invokeAll(callables);
            for(Future<String> task : list){
                System.out.println("Tasks " + task.get());
            }
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        myCallableInvokeAny();
        myCallableInvokeAll();
    }
}
