package com.venkat.test;

/**
 * Created by Venkatram on 3/8/2017.
 */
public class GenericStack<E> {

    private int size;
    private int top;
    private E[] elements;

    public GenericStack(){
        this(10);
    }

    public GenericStack(int size){
        this.size = size > 0 ? size : 10;
        this.top = -1;
        this.elements = (E[]) new Object[this.size];
    }

    public void push(E element){
        if(top < size - 1){
            this.elements[++top] = element;
        }
    }

    public E pop(){
        if(top > -1 && top < size){
            return elements[top--];
        }
        throw new ArrayIndexOutOfBoundsException("No elements");
    }

    public static void main(String[] args){
        GenericStack<Integer> ints = new GenericStack<>();
        ints.push(123);

        ints.push(1234);

        System.out.printf( "%s, %s", ints.pop(), ints.pop());
    }
}
