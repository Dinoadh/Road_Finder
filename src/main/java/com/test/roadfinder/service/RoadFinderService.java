package com.test.roadfinder.service;

import com.test.roadfinder.graph.RoadGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * Service class to check if roads are connected.
 */
@Service
public class RoadFinderService {

    @Autowired
    private RoadGraph roadGraph;

    public boolean checkIfCityConnected(String origin, String destination) {
        LinkedList<String> visited = new LinkedList<>();
        visited.add(origin);
        return roadGraph.depthFirst(visited, destination);
    }
}
