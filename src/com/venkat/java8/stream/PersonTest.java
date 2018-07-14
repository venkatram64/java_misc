package com.venkat.java8.stream;

import com.venkat.java8.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Venkatram on 3/11/2017.
 */
public class PersonTest {

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

        persons.stream()
                .filter(p -> p.getLastName().startsWith("V"))
                .forEach(System.out::println);
    }
}
