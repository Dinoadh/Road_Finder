package com.test.roadfinder.controller;

import com.test.roadfinder.service.RoadFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The Rest Controller class which exposes the API to find out if the two roads are connected or not
 */
@Controller
@RequestMapping("/connected")
public class RoadFinderController {

    @Autowired
    private RoadFinderService roadFinderService;

    @GetMapping
    @ResponseBody
    public String checkIfConnected(@RequestParam("origin") String origin, @RequestParam("destination") String destination) {
        return roadFinderService.checkIfCityConnected(origin, destination) ? "yes" : "no";
    }
}
