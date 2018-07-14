package com.venkat.work.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venkatram on 2/26/2017.
 */
public class Product implements Subject {

    private String productName;
    private List<Observer> observerList = new ArrayList<>();
    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
        if(this.available){
            this.notifyObservers();
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observerList){
            o.update(this.getProductName());
        }
    }
}
