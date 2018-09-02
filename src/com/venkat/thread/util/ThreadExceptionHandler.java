package com.venkat.thread.util;

public class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String handlerId;

    public ThreadExceptionHandler(String handlerId){
        this.handlerId = handlerId;
    }

    public ThreadExceptionHandler(){}

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(this + "caught exception in thread " +
                    t.getName() + " => " + e);
    }

    @Override
    public String toString() {
        return "ThreadExceptionHandler{ @" + this.hashCode() +
                "  handlerId='" + handlerId + '\'' +
                '}';
    }
}
