package com.example.Gmovie;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class MovieEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;
        String title;

        private String director;
        private String actors;
        private String release;
        private String description;
        private int ratings;

        public MovieEntity(String title) {
            this.title = title;

        }

        public MovieEntity(String title, String director, String actors, String release, String description, int ratings) {
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
                return this.actors;
        }

        public String getRelease() {
                return this.release;
        }

        public String getDescription() {
                return this.description;
        }

        public int getRatings() {
                return this.ratings;
        }

        public String getTitle() {
                return this.title;
        }
}
