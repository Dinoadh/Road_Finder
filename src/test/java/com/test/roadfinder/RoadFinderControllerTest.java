package com.test.roadfinder;

import com.test.roadfinder.config.RoadFinderConfig;
import com.test.roadfinder.controller.RoadFinderController;
import com.test.roadfinder.service.RoadFinderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(RoadFinderController.class)
@ContextConfiguration(classes = {RoadFinderApplication.class, RoadFinderConfig.class})
public class RoadFinderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoadFinderService roadFinderService;

    @Test
    public void shouldReturnYes() throws Exception {
        when(roadFinderService.checkIfCityConnected("Boston", "Philadelphia")).thenReturn(true);
        this.mockMvc.perform(get("/connected")
                .queryParam("origin", "Boston").queryParam("destination", "Philadelphia"))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("yes")));
    }

    @Test
    public void shouldReturnNo() throws Exception {
        when(roadFinderService.checkIfCityConnected("Philadelphia", "Albany")).thenReturn(false);
        this.mockMvc.perform(get("/connected")
                .queryParam("origin", "Philadelphia").queryParam("destination", "Albany"))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("no")));
    }

    @Test
    public void shouldThrowBadRequest() throws Exception {
        this.mockMvc.perform(get("/connected")).andExpect(status().isBadRequest());
        this.mockMvc.perform(get("/connected").queryParam("origin", "SomeParam")).andExpect(status().isBadRequest());
    }
}
