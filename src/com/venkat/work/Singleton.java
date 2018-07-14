package com.venkat.work;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * Created by Venkatram on 2/18/2017.
 */
public class Singleton implements Serializable{

    private static final long serialVersionUID = 1L;

    private static Singleton instance = new Singleton();

    private Singleton(){
        System.out.println("Sole instance is created...");
    }

    public static Singleton getInstance(){
        return instance;
    }
}

class TestClass{
    public static void main(String[] args) throws Exception {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        print("s1", s1);
        print("s1", s2);

        //Reflection
        Class clazz = Class.forName("com.venkat.work.Singleton");
        Constructor<Singleton>[] ctors = clazz.getDeclaredConstructors();
        Constructor<Singleton> ctor = ctors[0];
        ctor.setAccessible(true);
        Singleton s = ctor.newInstance();
        print("reflection ", s);
        //Serialization
        Singleton ser = Singleton.getInstance();
        print("serialization", ser);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/ser.ser"));
        oos.writeObject(ser);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/ser.ser"));
        Singleton ser2 = (Singleton)ois.readObject();
        print("serialization", ser2);
    }

    private static void print(String name, Singleton obj) {
        System.out.println(String.format("Object: :%s, Hashcode: %d", name, obj.hashCode()));
    }
}
