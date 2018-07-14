package com.venkat.work.factory;

/**
 * Created by Venkatram on 2/25/2017.
 */
public enum PlanType {
    DOMESTIC_PLAN("DOMESTIC_PLAN"),
    COMMERCIAL_PLAN("COMMERCIAL_PLAN"),
    INSTITUTIONAL_PLAN("INSTITUTIONAL_PLAN");

    private String name;

    private PlanType(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
