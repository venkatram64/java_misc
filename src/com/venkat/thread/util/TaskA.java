package com.venkat.thread.util;

import java.util.concurrent.TimeUnit;

public class TaskA implements Runnable {

    private static int count = 0;
    private int id;

    @Override
    public void run() {
        System.out.println("#####<Task-" + id + "> Starting... ");
        for(int i = 0; i<10; i++){
            System.out.println("<Task-" + id + ">Tick Tick " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("*****<Task-" + id + "> Ending... ");
    }

    public TaskA(){
        this.id = ++count;
    }
}
