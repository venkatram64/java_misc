package com.venkat.work.cp.builder;

/**
 * Created by Venkatram on 3/20/2017.
 */
public class Account {

    private final int accountId;
    private final String email;
    private final Address address;
    private final Person person;
    //private ContactDetails contactDetails;

    private Account(Builder builder){
        this.accountId = builder.accountId;
        this.email = builder.email;
        this.address = builder.address;
        this.person = builder.person;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Person getPerson() {
        return person;
    }

    public static class Builder {
        private int accountId;
        private String email;
        private Address address;
        private Person person;
        //private ContactDetails contactDetails;

        public Builder accountId(final int accountId){
            this.accountId = accountId;
            return this;
        }

        public Builder email(final String email){
            this.email = email;
            return this;
        }

        public Builder address(final Address address){
            this.address = address;
            return this;
        }

        public Builder person(final Person person){
            this.person = person;
            return this;
        }

        public Account build(){
            return new Account(this);
        }
    }
}
