package com.example.Gmovie;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GmovieController {

    @GetMapping("/movies")
    public String getMovies(){
        return "[]";
    }

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovie(){

    }
}
