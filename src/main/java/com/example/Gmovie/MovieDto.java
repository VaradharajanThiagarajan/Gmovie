package com.example.Gmovie;

import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
public class MovieDto {

    private String title;

    public MovieDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
