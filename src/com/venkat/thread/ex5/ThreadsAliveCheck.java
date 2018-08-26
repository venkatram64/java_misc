package com.venkat.thread.ex5;


import com.venkat.thread.util.TaskF;

import java.util.concurrent.TimeUnit;

public class ThreadsAliveCheck {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Thread t1 = new Thread(new TaskF(500),"Thread-1");

        Thread t2 = new Thread(new TaskF(1000),"Thread-2");

        boolean t1Alive = t1.isAlive();
        boolean t2Alive = t2.isAlive();

        System.out.println("[" + currentThreadName + "] before starting ..." + t1.getName() + " is alive " + t1Alive);
        System.out.println("[" + currentThreadName + "] before starting ..." + t2.getName() + " is alive " + t2Alive);

        t1.start();
        t2.start();

        while(true){
            TimeUnit.MILLISECONDS.sleep(500);
            t1Alive = t1.isAlive();
            t2Alive = t2.isAlive();
            System.out.println("[" + currentThreadName + "] before starting ..." + t1.getName() + " is alive " + t1Alive);
            System.out.println("[" + currentThreadName + "] before starting ..." + t2.getName() + " is alive " + t2Alive);

            if(!t1Alive && !t2Alive){
                break;
            }
        }


        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
