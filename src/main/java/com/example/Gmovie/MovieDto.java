package com.example.Gmovie;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
public class MovieDto {

    private String title;

    public MovieDto(String title) {
        this.title = title;
    }
}
