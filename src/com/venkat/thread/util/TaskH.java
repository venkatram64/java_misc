package com.venkat.thread.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TaskH implements Runnable {

    private static int count = 0;
    private int id;
    private String taskName ;

    private final int Data_SIZE = 100000;

    @Override
    public void run() {
        System.out.println("#####["+Thread.currentThread().getName() +"]<" + this.taskName + "> Starting... ");
        for(int i = 0; i< 5; i++){
            System.out.println("["+Thread.currentThread().getName() +"]<" + this.taskName + ">Tick Tick " + i);
            doSomeWork();

            if(Thread.interrupted()){
                System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> interrupted, Cancelling... ");
                break;
            }
        }
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> interrupted, status ... "
                + Thread.interrupted());
        System.out.println("*****["+Thread.currentThread().getName() +"]<" + this.taskName + "> Ending... ");
    }

    private void doSomeWork(){
        for(int i = 0; i < 2; i ++){
            Collections.sort(generateDataSet());
        }
    }

    private List<Integer> generateDataSet(){
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < Data_SIZE; i++){
            list.add(random.nextInt(Data_SIZE));
        }
        return list;
    }

    public TaskH(){
        this.id = ++count;
        this.taskName = "TaskH-" + id;
    }
}
