package com.example.Gmovie;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GmovieController {

    ArrayList<MovieDto>  movieList;

    public GmovieController(){
         movieList = new ArrayList<MovieDto>();
    }

    @GetMapping("/movies")
    public List<MovieDto> getMovies(){
        return this.movieList;

    }

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovie(@RequestBody MovieDto moviesdto){
        movieList.add(moviesdto);

    }
}
