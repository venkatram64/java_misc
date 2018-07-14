package com.venkat.work.memento;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class Originator {

    private String state;
    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

    public Memento saveStateToMemento(){
        return new Memento(this.state);
    }

    public void getStateFromMemento(Memento memento){
        this.state = memento.getState();
    }
}
