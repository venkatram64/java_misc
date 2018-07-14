package com.venkat.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Venkatram on 3/10/2017.
 */
public class PersonTest {

    /*public static void print(List<Person> persons, Condition condition){
        for(Person p : persons){
            if(condition.test(p)){
                System.out.println(p);
            }
        }
    }*/

    public static void print(List<Person> persons, Predicate<Person> predicate){
        for(Person p : persons){
            if(predicate.test(p)){
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args){
        List<Person> persons = Arrays.asList(
                new Person("Venkatram", "Veerareddy", 52),
                new Person("Anitha", "Veerareddy", 46),
                new Person("Shamanthaka", "Veerareddy", 20),
                new Person("Srijan", "Veerareddy", 16),
                new Person("Akhil", "Bandi", 26),
                new Person("Nikhil", "Bandi", 24),
                new Person("Aaryaa", "Bandi", 10),
                new Person("Vasuki", "Bandi", 6)
        );
        //1. printing all
        System.out.println("Printing all...");
        print(persons, p -> true);

        //2. printing name starting with A
        System.out.println("Starts with A...");
        print(persons, p -> p.getFirstName().startsWith("A"));

        //3. printing last name starting with V
        System.out.println("Starts with V...");
        print(persons, p -> p.getLastName().startsWith("V"));

        //4. printing sorted persons
        System.out.println("Sorted by age...");
        Collections.sort(persons, (p1, p2) -> p1.getAge() - p2.getAge());
        print(persons, p -> true);
    }
}
