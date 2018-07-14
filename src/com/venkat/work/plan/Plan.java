package com.venkat.work.plan;

/**
 * Created by Venkatram on 2/25/2017.
 */
public abstract class Plan {

    protected double rate;
    public abstract void getRate();

    public double calculateBill(int units){
        return units * rate;
    }
}
