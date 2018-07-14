package com.venkat.work.state;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class StatePatternTest {

    public static void main(String[] args){
        SeasonContext sc = new SeasonContext();
        sc.nextSeason();
        sc.nextSeason();
        sc.nextSeason();
    }
}
