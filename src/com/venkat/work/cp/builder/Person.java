package com.venkat.work.cp.builder;

/**
 * Created by Venkatram on 3/20/2017.
 */
public class Person {

    private final String firstName;
    private final String lastName;

    private Person(Builder builder){
        firstName = builder.firstName;
        lastName = builder.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class Builder {
        private String firstName;
        private String lastName;

        public Builder firstName(final String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(final String lastName){
            this.lastName = lastName;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
