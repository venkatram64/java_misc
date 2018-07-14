package com.venkat.thread.webcrawler6;

import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venkatram on 3/16/2017.
 */
public class LinkFinder implements Runnable {

    private String url;
    private LinkHandler linkHandler;

    private static final long t0 = System.nanoTime();

    public LinkFinder(String url, LinkHandler linkHandler){
        this.url = url;
        this.linkHandler = linkHandler;
    }

    @Override
    public void run() {
        getSimpleLinks(this.url);
    }

    private void getSimpleLinks(String url) {
        //if not already visited
        if (!linkHandler.visited(url)) {
            try {
                URL uriLink = new URL(url);
                Parser parser = new Parser(uriLink.openConnection());
                NodeList list = parser.extractAllNodesThatMatch(new NodeClassFilter(LinkTag.class));
                List<String> urls = new ArrayList<String>();

                for (int i = 0; i < list.size(); i++) {
                    LinkTag extracted = (LinkTag) list.elementAt(i);

                    if (!extracted.getLink().isEmpty()
                            && !linkHandler.visited(extracted.getLink())) {

                        urls.add(extracted.getLink());
                    }

                }
                //we visited this url
                linkHandler.addVisited(url);
                System.out.println("link size is " + linkHandler.size());

                if (linkHandler.size() == 1500) {
                    System.out.println("Time to visit 1500 distinct links = " + (System.nanoTime() - t0));
                }

                for (String l : urls) {
                    linkHandler.queueLink(l);
                }

            } catch (Exception e) {
                //ignore all errors for now
                e.printStackTrace();
            }
        }
    }
}
