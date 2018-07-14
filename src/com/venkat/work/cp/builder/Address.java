package com.venkat.work.cp.builder;

/**
 * Created by Venkatram on 3/20/2017.
 */
public class Address {

    private final String houseNumber;
    private final String street;
    private final String zipCode;
    private final String city;

    private Address(Builder builder){
        this.houseNumber = builder.houseNumber;
        this.street = builder.street;
        this.zipCode = builder.zipCode;
        this.city = builder.city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public static class Builder{
        private String houseNumber;
        private String street;
        private String zipCode;
        private String city;

        public Builder houseNumber(final String houseNumber){
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder street(final String street){
            this.street = street;
            return this;
        }

        public Builder zipCode(final String zipCode){
            this.zipCode = zipCode;
            return this;
        }

        public Builder city(final String city){
            this.city = city;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}
