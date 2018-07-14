package com.venkat.algorithm;

/**
 * Created by Venkatram on 3/12/2017.
 */
public class Queue {

    private int size;
    private int front;
    private int rear;
    private int[] queue;

    public Queue(){
        super();
        this.size = 50;
        this.queue = new int[50];
        this.front = -1;
        this.rear = -1;

    }

    public Queue(int size){
        this();
        this.size = size;
    }

    public Queue(int size,int front, int rear){
        this(size);
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty(){
        return this.rear == -1;
    }

    public boolean isFull(){
        return this.front == this.size;
    }

    public void enque(int element){
        if(!isFull()){
            if(rear == -1){
                this.rear = 0;
            }
            queue[++front] = element;
        }else{
            throw new ArrayIndexOutOfBoundsException("Queue is full");
        }
    }

    public int deque(){
        if(!isEmpty()){
            return queue[this.rear++];
        }else{
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
    }

    public static void main(String[] args){
        Queue q = new Queue();
        q.enque(66);
        q.enque(88);
        q.enque(65);

        System.out.println(q.deque() + ", "+ q.deque() + ", " + q.deque());
    }

}
