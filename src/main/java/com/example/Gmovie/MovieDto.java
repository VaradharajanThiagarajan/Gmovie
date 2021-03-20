package com.example.Gmovie;

import lombok.Value;

@Value
public class MovieDto {

    private String title;

    public MovieDto(String title) {
        this.title = title;
    }
}
