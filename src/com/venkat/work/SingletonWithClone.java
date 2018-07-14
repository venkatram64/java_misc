package com.venkat.work;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * Created by Venkatram on 2/18/2017.
 */
public class SingletonWithClone implements Cloneable {

    private static SingletonWithClone instance = new SingletonWithClone();

    private SingletonWithClone(){
        System.out.println("Sole instance is created...");
    }

    public static SingletonWithClone getInstance(){
        return instance;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class TestSCClass{
    public static void main(String[] args) throws CloneNotSupportedException {
        SingletonWithClone s1 = SingletonWithClone.getInstance();
        SingletonWithClone s2 = SingletonWithClone.getInstance();

        print("s1", s1);
        print("s1", s2);

        SingletonWithClone s3 = (SingletonWithClone)s2.clone();
        print("s3", s3);

    }

    private static void print(String name, SingletonWithClone obj) {
        System.out.println(String.format("Object: :%s, Hashcode: %d", name, obj.hashCode()));
    }
}
