package com.venkat.work.state;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class Summer implements Season {
    @Override
    public void nextSeason(SeasonContext context) {
        System.out.println("Summer season running...");
        context.setSeason(new Monsoon());
    }
}
