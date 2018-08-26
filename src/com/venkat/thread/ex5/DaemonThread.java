package com.venkat.thread.ex5;


import com.venkat.thread.util.TaskF;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Thread t1 = new Thread(new TaskF(500),"Thread-1");
        //t1.setDaemon(true);

        Thread t2 = new Thread(new TaskF(1000),"Thread-2");
        t2.setDaemon(true);

        t1.start();
        t2.start();


        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
