package com.test.roadfinder.graph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Class which holds City Mapping in In-Memory Map using adjacency matrix.
 * To find out whether one city connects to another it is doing depth first search.
 */
public class RoadGraph extends HashMap<String, LinkedHashSet<String>> {

    /**
     * Add edge to graph
     */
    public void addEdge(String node1, String node2) {
        LinkedHashSet<String> adjacent = get(node1);
        if(adjacent==null) {
            adjacent = new LinkedHashSet<>();
            put(node1, adjacent);
        }
        adjacent.add(node2);
    }

    /**
     * Add an edge in bi-directed form
     */
    public void addTwoWayVertex(String node1, String node2) {
        addEdge(node1, node2);
        addEdge(node2, node1);
    }

    /**
     * Method to perform depth first search.
     */
    public boolean depthFirst(LinkedList<String> visited, String end) {
        LinkedHashSet<String> nodes = get(visited.getLast());
        if(nodes == null) return false;
        if(nodes.contains(end)) return true;
        boolean found = false;
        for (String node : nodes) {
            if (visited.contains(node)) continue;
            visited.addLast(node);
            if(depthFirst(visited, end)) found = true;
        }
        return found;
    }

}
