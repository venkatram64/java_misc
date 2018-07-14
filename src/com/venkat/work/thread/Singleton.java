package com.venkat.work.thread;


import java.io.*;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Venkatram on 2/18/2017.
 */
public class Singleton implements Serializable{
    private static Singleton instance = null;

    private Singleton(){
        if(instance != null){
            throw new RuntimeException("Can not create, please use getInstance() method");
        }
        System.out.println("Sole instance is created...");
    }
    //double check ideom
    public static Singleton getInstance(){
        if(instance == null){//check 1
            synchronized (Singleton.class) {
                if(instance == null) {//check 2
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("read resolved...");
        return instance;
    }
}

class TestClass{

    static void useSingleton(){
        Singleton s1 = Singleton.getInstance();
        print("s1 thread", s1);
    }

    public static void main(String[] args) throws Exception {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        print("s1", s1);
        print("s1", s2);

        //Serialization
     /*   Singleton ser = Singleton.getInstance();
        print("serialization", ser);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/ser.ser"));
        oos.writeObject(ser);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/ser.ser"));
        Singleton ser2 = (Singleton)ois.readObject();
        print("serialization", ser2);*/



        //thread
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(TestClass::useSingleton);
        service.submit(TestClass::useSingleton);
        service.submit(TestClass::useSingleton);
        service.submit(TestClass::useSingleton);
        service.shutdown();

        //Reflection
       /* Class clazz = Class.forName("com.venkat.work.thread.Singleton");
        Constructor<Singleton>[] ctors = clazz.getDeclaredConstructors();
        Constructor<Singleton> ctor = ctors[0];
        ctor.setAccessible(true);
        Singleton s = ctor.newInstance();
        print("reflection ", s);*/

    }

    private static void print(String name, Singleton obj) {
        System.out.println(String.format("Object: :%s, Hashcode: %d", name, obj.hashCode()));
    }
}
