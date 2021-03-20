package com.example.Gmovie;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GmovieController {

   // ArrayList<MovieDto>  movieList;
    MovieService movieService;

    public GmovieController(MovieService movieService){
         //movieList = new ArrayList<MovieDto>();
        this.movieService = movieService ;
    }

    @GetMapping("/movies")
    public List<MovieDto> getMovies(){
        return this.movieService.fetchAll();

    }

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovie(@RequestBody MovieDto moviesdto){
        //movieList.add(moviesdto);
        this.movieService.create(moviesdto);

    }
}
