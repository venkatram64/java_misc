package com.venkat.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Venkatram on 2/23/2017.
 */
public class ArrayBlockingQueueTest {

    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

    public static void producer() throws InterruptedException{
        Random random = new Random();
        while(true) {
            int val = random.nextInt(100);
            blockingQueue.put(val);
            System.out.println("Produced: " + val);
        }
    }

    public static void consumer() throws InterruptedException {
        Random random = new Random();
        while (true){
            Thread.sleep(100);
            if(random.nextInt(10) == 0){
                int val = blockingQueue.take();
                System.out.println("Consumed: " + val + " quequ size is " + blockingQueue.size());
            }

        }
    }


    public static void main(String[] args){
        Thread t1 = new Thread(()-> {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
