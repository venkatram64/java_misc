package com.venkat.thread.ex4;

import com.venkat.thread.util.ResultNotifier;

public class SumObserver implements ResultNotifier<Integer> {

    private String taskId;

    public SumObserver(String taskId){
        this.taskId = taskId;
    }

    @Override
    public void notifyResult(Integer result) {
        System.out.println("Result for " + taskId + " = " + result);
    }
}
