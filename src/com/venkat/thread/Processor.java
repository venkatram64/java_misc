package com.venkat.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Venkatram on 2/23/2017.
 */
public class Processor {

    private LinkedList<Integer> ll = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public  void producer() throws InterruptedException{
        int value = 0;
        while(true){
            synchronized (lock){
                while(ll.size() == LIMIT){
                    lock.wait();
                }
                ll.add(value++);
                lock.notifyAll();
            }
        }
    }

    public void consumer() throws InterruptedException{
        Random random = new Random();
        while(true){
            synchronized (lock) {
                while(ll.size() == 0){
                    lock.wait();
                }
                System.out.println("List size is : " + ll.size());
                int value = ll.removeFirst();
                System.out.println("; value is " + value);
                lock.notifyAll();
            }
            Thread.sleep(random.nextInt(1000));
        }
    }

    public static void main(String[] args){
        Processor p = new Processor();
        Thread t1 = new Thread(()-> {
            try {
                p.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                p.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
