package com.venkat.thread.ex;

import java.util.concurrent.TimeUnit;

public class FifthWay {

    public static void main(String[] args) {

        System.out.println("Main thread start here...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<10; i++){
                    System.out.println("Tick Tick " + i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        System.out.println("Main thread ends here...");
    }
}
