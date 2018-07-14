package com.venkat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Venkatram on 3/13/2017.
 */
public class Graph {

    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public static class Node{
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();
        private Node(int id){
            this.id = id;
        }
    }

    private Node getNode(int id){
        return new Node(id);
    }

    public void addEdge(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node souce, Node destination, HashSet<Integer> visited){
        if(visited.contains(souce.id)){
            return false;
        }
        visited.add(souce.id);
        if(souce == destination){
            return true;
        }

        for(Node child : souce.adjacent){
            if(hasPathDFS(child, destination, visited)){
                return true;
            }
        }

        return false;
    }

    public boolean hasPathBFS(int source, int destination){
        return hasPathBFS(getNode(source), getNode(destination));
    }
    private boolean hasPathBFS(Node source, Node destination){
        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(source);
        while(!nextToVisit.isEmpty()){
            Node node = nextToVisit.remove();
            if(node == destination){
                return true;
            }

            if(visited.contains(node.id)){
                continue;
            }
            visited.add(node.id);
            for(Node child : node.adjacent){
                nextToVisit.add(child);
            }
        }
        return false;
    }

}
