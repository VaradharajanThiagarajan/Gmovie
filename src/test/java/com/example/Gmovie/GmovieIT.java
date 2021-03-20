package com.example.Gmovie;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GmovieIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    //Given the GBDB is empty
    //When I visit GMDB movies
    //Then I should see no movies

    @Test
    public void getMoviesEmptyList() throws Exception{

        mockMvc.perform(get("/movies")
        ).andExpect(status().isOk())
        .andExpect(jsonPath("length()").value(0));
    }


    //Given a new movie has released
    //When I submit this new movie to GMDB movies
    //Then I should see that movie in GMDB movies

    @Test
    public void addMovie() throws Exception{

        MovieDto movie1 = new MovieDto("The Avengers");
        mockMvc.perform(post("/movies")
                .content(objectMapper.writeValueAsString(movie1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());


    }

}
