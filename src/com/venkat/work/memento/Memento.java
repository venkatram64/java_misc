package com.venkat.work.memento;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class Memento {

    private String state;
    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }


}
