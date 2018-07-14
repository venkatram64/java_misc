package com.venkat.test;

/**
 * Created by Venkatram on 2/24/2017.
 */
public class PrivateStaticMethod {

    private final String concat;

    public PrivateStaticMethod(String concat){
        this.concat = concat;
    }

    public PrivateStaticMethod(String s, String s2){
        concat = concat(s, s2);
    }

    private static String concat(String s1, String s2){
        return String.format("%s --- %s", s1, s2);
    }

    public String getConcat(){
        return this.concat;
    }

    public static void main(String[] args){
        System.out.println(new PrivateStaticMethod("venkat", "ram").getConcat());
    }
}
