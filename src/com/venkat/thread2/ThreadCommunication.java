package com.venkat.thread2;

public class ThreadCommunication {

    public void producer() throws InterruptedException{

        synchronized (this){
            System.out.println("I am in producer method...");
            wait();
            System.out.println("I am done in producer method...");
        }
    }

    public void consumer() throws InterruptedException{

        Thread.sleep(1000);
        synchronized (this){
            System.out.println("I am in consumer method...");
            notify();
            System.out.println("I am done in consumer method...");
        }
    }

    public static void main(String[] args) {

        ThreadCommunication c = new ThreadCommunication();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
