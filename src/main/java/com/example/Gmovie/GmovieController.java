package com.example.Gmovie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GmovieController {

    @GetMapping("/movies")
    public String getBooks(){
        return "[]";
    }

}
