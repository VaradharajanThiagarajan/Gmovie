package com.example.Gmovie;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

public class GmovieIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    //Given the GBDB is empty
    //When I visit GMDB movies
    //Then I should see no movies
    //

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

        mockMvc.perform(get("/movies")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].title").value("The Avengers"));


    }

    //Given the GMDB has many movies
    //When I visit GMDB movies
    //Then I should see that movie in GMDB movies

    @Test
    public void getManyMovies() throws Exception{

        MovieDto movie1 = new MovieDto("The Avengers");
        MovieDto movie2 = new MovieDto("The Ballers");
        mockMvc.perform(post("/movies")
                .content(objectMapper.writeValueAsString(movie1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockMvc.perform(post("/movies")
                .content(objectMapper.writeValueAsString(movie2))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        mockMvc.perform(get("/movies")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andExpect(jsonPath("[0].title").value("The Avengers"))
                .andExpect(jsonPath("[1].title").value("The Ballers"));



    }


    //Given the GMDB has many movies
    //When I visit GMDB movies with an existing title
    //Then I should see that movie's details

    @Test
    public void getMovieDetailsByTitle() throws Exception {
        MovieDto movie1 = new MovieDto("The Avengers","Joss Wheadon","Robert Downey Jr.","2012","good movie",1);
        MovieDto movie2 = new MovieDto("The Ballers","mortl","Robert Downey Jr.","2014","bad movie",2);
        MovieDto movie3 = new MovieDto("The coolers","mortl","Robert Downey Jr.","2014","bad movie",2);


        mockMvc.perform(post("/movies")
                .content(objectMapper.writeValueAsString(movie1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockMvc.perform(post("/movies")
                .content(objectMapper.writeValueAsString(movie2))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        mockMvc.perform(get(String.format("/movies/%s", movie1.getTitle()))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("The Avengers"))
                .andExpect(jsonPath("$.director").value("Joss Wheadon"))
                .andExpect(jsonPath("$.actors").value("Robert Downey Jr."))
                .andExpect(jsonPath("$.release").value("2012"))
                .andExpect(jsonPath("$.description").value("good movie"))
                .andExpect(jsonPath("$.ratings").value(1));



    }

    //Given the GMDB has many movies
    //When I visit GMDB movies with a non-existing title
    //Then I receive a friendly message that it doesn't exist
    @Test
    public void getMovieDetailsNotFound() throws Exception {

        mockMvc.perform(get(String.format("/movies/%s","somu"))
        ).andExpect(status().isNotFound())
                .andExpect(jsonPath("message").value("movie does not exist"));

    }


}
