package com.venkat.work.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class CareTaker {
    private List<Memento> mementoes = new ArrayList<>();

    public void add(Memento memento){
        mementoes.add(memento);
    }

    public Memento get(int index){
        return mementoes.get(index);
    }
}
