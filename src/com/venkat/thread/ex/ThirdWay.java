package com.venkat.thread.ex;

import java.util.concurrent.TimeUnit;

public class ThirdWay {

    public static void main(String[] args) {
        System.out.println("Main thread start here...");
        new ThirdTask();
        new ThirdTask();
        System.out.println("Main thread ends here...");
    }
}

class ThirdTask implements Runnable {

    private static int count = 0;
    private int id;

    public void run(){
        for(int i = 0; i<10; i++){
            System.out.println("<"+ id +">Tick Tick " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ThirdTask(){
        this.id = ++count;
        new Thread(this).start();
    }
}
