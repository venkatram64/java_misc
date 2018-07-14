package com.venkat.work.observer;

/**
 * Created by Venkatram on 2/26/2017.
 */
public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
