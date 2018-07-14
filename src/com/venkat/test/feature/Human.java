package com.venkat.test.feature;

/**
 * Created by Venkatram on 6/11/2017.
 */
public class Human {

    private String name;
    private Integer age;

    public Human(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public final void test(){
        System.out.println("I am final.");
    }


}
