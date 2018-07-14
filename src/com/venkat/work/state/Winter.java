package com.venkat.work.state;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class Winter implements Season {
    @Override
    public void nextSeason(SeasonContext context) {
        System.out.println("Winter is running...");
        context.setSeason(new Summer());
    }
}
