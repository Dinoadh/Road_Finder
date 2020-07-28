package com.test.roadfinder;

import com.test.roadfinder.controller.RoadFinderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RoadFinderApplicationTests {

	@Autowired
	private RoadFinderController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
