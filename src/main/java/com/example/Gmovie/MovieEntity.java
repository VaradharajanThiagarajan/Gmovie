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
        public MovieEntity(String title) {
            this.title = title;

        }

        public String getTitle() {
                return title;
        }
}
