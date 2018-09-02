package com.venkat.thread.ex9;

import com.venkat.thread.ex4.SumObserver;
import com.venkat.thread.util.TaskDD;
import com.venkat.thread.util.TaskE;

public class ReturningValuesThirdWay {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        TaskDD task1 = new TaskDD(2,3, 500);
        Thread t1 = new Thread(task1,"Thread-1");

        TaskDD task2 = new TaskDD(4,5, 1000);
        Thread t2 = new Thread(task2,"Thread-2");

        TaskDD task3 = new TaskDD(6,7, 2000);
        Thread t3 = new Thread(task3,"Thread-3");

        task1.start();
        task2.start();
        task3.start();

        task1.join();
        System.out.println("Result-1= " + task1.getSum());

        task2.join();
        System.out.println("Result-2= " + task2.getSum());

        task3.join();
        System.out.println("Result-3= " + task3.getSum());

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
