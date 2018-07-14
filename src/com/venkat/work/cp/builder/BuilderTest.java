package com.venkat.work.cp.builder;

/**
 * Created by Venkatram on 3/20/2017.
 */
public class BuilderTest {
    public static void main(String[] args){

        Person person = new Person.Builder()
                .firstName("Venkatram")
                .lastName("Veerareddy")
                .build();

        Address address = new Address.Builder()
                .houseNumber("123 Main")
                .city("rochester")
                .zipCode("123123")
                .build();

        Account account = new Account.Builder()
                .accountId(12345)
                .person(person)
                .address(address)
                .build();

    }
}
