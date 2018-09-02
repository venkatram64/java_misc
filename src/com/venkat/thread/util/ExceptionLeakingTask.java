package com.venkat.thread.util;

public class ExceptionLeakingTask implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
