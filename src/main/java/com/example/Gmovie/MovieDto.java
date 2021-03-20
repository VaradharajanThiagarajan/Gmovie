package com.example.Gmovie;

import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
public class MovieDto {

    private String title;
    private String director;
    private String actors;
    private String release;
    private String description;
    private int ratings;


    public MovieDto(String title) {
        this.title = title;
    }

    public MovieDto(String title, String director, String actors, String release, String description, int ratings) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.release = release;
        this.description = description;
        this.ratings = ratings;

    }

    public String getDirector() {
        return this.director;
    }

    public String getActors() {
        return actors;
    }

    public String getRelease() {
        return release;
    }

    public String getDescription() {
        return description;
    }

    public int getRatings() {
        return ratings;
    }

    public String getTitle() {
        return title;
    }
}
