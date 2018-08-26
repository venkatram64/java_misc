package com.venkat.thread.util;

import java.util.concurrent.ThreadFactory;

public class NamedThreadImpl implements ThreadFactory {

    private static int count = 0;
    private static String NAME = "MyThread-";

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, NAME + (++count));
        return t;
    }
}
