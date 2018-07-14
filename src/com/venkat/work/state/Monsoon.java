package com.venkat.work.state;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class Monsoon implements Season {
    @Override
    public void nextSeason(SeasonContext context) {
        System.out.println("Monsoon is running ...");
        context.setSeason(new Winter());
    }
}
