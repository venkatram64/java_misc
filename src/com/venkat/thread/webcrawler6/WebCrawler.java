package com.venkat.thread.webcrawler6;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Venkatram on 3/16/2017.
 */
public class WebCrawler implements LinkHandler {

    private final Collection<String> visitedLinks = Collections.synchronizedSet(new HashSet<>());
    private String url;
    private ExecutorService executorService;

    public WebCrawler(String startingURL, int maxThreads){
        this.url = startingURL;
        executorService = Executors.newFixedThreadPool(maxThreads);
    }

    private void startNewThread(String link) throws Exception{
        executorService.execute(new LinkFinder(link, this));
    }

    private void startCrawling() throws Exception{
        startNewThread(this.url);
    }

    @Override
    public void queueLink(String link) throws Exception {
        startNewThread(link);
    }

    @Override
    public int size() {
        return visitedLinks.size();
    }

    @Override
    public boolean visited(String link) {
        return visitedLinks.contains(link);
    }

    @Override
    public void addVisited(String link) {
        visitedLinks.add(link);
    }

    public static void main(String[] args) throws Exception{
        new WebCrawler("http://www.javaworld.com", 64);
    }
}
