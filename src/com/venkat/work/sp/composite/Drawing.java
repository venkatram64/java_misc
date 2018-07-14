package com.venkat.work.sp.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class Drawing implements Shape {

    private List<Shape> shapes = new ArrayList<>();

    public void add(Shape s){
        shapes.add(s);
    }

    public void remove(Shape s){
        shapes.remove(s);
    }

    public void clear(){
        shapes.clear();
    }

    @Override
    public void draw() {
        for(Shape s : shapes){
            s.draw();
        }
    }
}
