package com.venkat.algorithm;

/**
 * Created by Venkatram on 3/12/2017.
 */
public class Stack {

    private int top;
    private int[] stack;
    private int size;

    public Stack(){
        this.top = -1;
        this.stack = new int[100];
        this.size = 100;
    }

    public Stack(int size){
        this.size = size;
        this.stack = new int[this.size];
        this.top = -1;
    }

    public boolean isFull(){
        return top == this.size - 1 ? true : false;
    }

    public boolean isEmpty(){
        return top == -1 ? true : false;
    }

    public void push(int element){
        if(!isFull()){
            stack[++top] = element;
        }else{
            throw new ArrayIndexOutOfBoundsException("Stack is full");
        }
    }

    public int pop(){
        if(!isEmpty()){
            return stack[top--];
        }else{
            throw new ArrayIndexOutOfBoundsException("Stack is Empty");
        }
    }

    public static void main(String[] args){
        Stack st = new Stack(10);
        st.push(2);
        st.push(5);

        System.out.println(st.pop() + ", " + st.pop());
    }
}
