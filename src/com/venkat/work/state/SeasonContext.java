package com.venkat.work.state;

/**
 * Created by Venkatram on 2/27/2017.
 */
public class SeasonContext {

    private Season season;
    public SeasonContext(){
        season = new Summer();
    }

    public void setSeason(Season season){
        this.season = season;
    }

    public void nextSeason(){
        this.season.nextSeason(this);
    }
}
