package com.venkat.thread;

/**
 * Created by Venkatram on 2/22/2017.
 */

class Item {

    private int content;
    private boolean available = false;

    public synchronized int get(){
        while(available == false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return content;
    }

    public synchronized void set(int content){
        while (available == true){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.content = content;
        available = true;
        notifyAll();
    }
}

class Producer extends Thread {

    private Item item;

    public Producer(Item item){
        this.item = item;
    }

    public void run(){
        int num = 0;
        while(true){
            System.out.println("Producer: " + num);
            item.set(num++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class  Consumer extends Thread {

    private Item item;

    public Consumer(Item item){
        this.item = item;
    }

    public void run(){
        while(true){
            System.out.println("Consumer: " + item.get());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ThreadCommunication {
    public static void main(String[] args){
        Item item = new Item();

        Producer p = new Producer(item);
        Consumer c = new Consumer(item);

        p.start();
        c.start();
    }
}
