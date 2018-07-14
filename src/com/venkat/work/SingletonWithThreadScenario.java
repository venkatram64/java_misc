package com.venkat.work;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Venkatram on 2/18/2017.
 */
public class SingletonWithThreadScenario{

        private static SingletonWithThreadScenario instance = null;

        private SingletonWithThreadScenario(){
            System.out.println("Sole instance is created...");
        }

        public static SingletonWithThreadScenario getInstance(){
            if(instance == null){
                instance = new SingletonWithThreadScenario();
            }
            return instance;
        }
}

class TestTClass{

    static void useSingleton(){
        SingletonWithThreadScenario s1 = SingletonWithThreadScenario.getInstance();
        print("s1", s1);
    }
    public static void main(String[] args) throws  Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(TestTClass::useSingleton);
        service.submit(TestTClass::useSingleton);

        service.shutdown();
    }

    private static void print(String name, SingletonWithThreadScenario obj) {
        System.out.println(String.format("Object: :%s, Hashcode: %d", name, obj.hashCode()));
    }
}
