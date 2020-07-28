package com.test.roadfinder.config;

import com.test.roadfinder.graph.RoadGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Initial configuration class to load city.txt file and keep in In-Memory map
 */
@Configuration
public class RoadFinderConfig {

    public final static Logger logger = LoggerFactory.getLogger(RoadFinderConfig.class);

    @Value("classpath:city.txt")
    private Resource cityFile;

    /**
     * Method gets the city mapping from city.txt file
     *
     * @return RoadGraph
     */
    @Bean
    public RoadGraph getCityMapping() {
        RoadGraph cityMap = new RoadGraph();
        try {
            List<String> lines = Files.readAllLines(Paths.get(cityFile.getURI()));
            lines.forEach(l -> {
                String[] cities = l.split(",");
                cityMap.addTwoWayVertex(cities[0].trim(), cities[1].trim());
            });
        } catch (IOException e) {
            logger.error("could not load mapping file", e);
        }
        return cityMap;
    }

}
