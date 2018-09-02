package com.venkat.thread.util;

public class ThreadFactoryWithExcepionHandler extends NamedThreadImpl {

    public Thread newThread(Runnable r){
        Thread t = super.newThread(r);
        t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        return t;
    }
}
