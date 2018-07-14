package com.venkat.thread.webcrawler6;

/**
 * Created by Venkatram on 3/16/2017.
 */
public interface LinkHandler {

    void queueLink(String link) throws Exception;

    int size();

    boolean visited(String link);

    void addVisited(String link);
}
