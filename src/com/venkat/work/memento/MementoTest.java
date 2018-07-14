package com.venkat.work.memento;

/**
 * Created by Venkatram on 3/2/2017.
 */
public class MementoTest {

    public static void main(String[] args){
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        originator.getStateFromMemento(careTaker.get(0));

        System.out.println(originator.getState());
    }
}
