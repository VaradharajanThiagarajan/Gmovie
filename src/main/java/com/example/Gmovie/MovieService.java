package com.example.Gmovie;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository mockRepository;

    MovieService(MovieRepository mockRepository){
        this.mockRepository = mockRepository;

    }
    public void create(MovieDto movieDto){
        //mockRepository.save(
          //      new MovieEntity(movieDto.getTitle())

                mockRepository.save(
                        new MovieEntity(movieDto.getTitle(),
                                movieDto.getDirector(),
                                movieDto.getActors(),
                                movieDto.getRelease(),
                                movieDto.getDescription(),
                                movieDto.getRatings()
                        )
        );

    }

    public List<MovieDto> fetchAll() {
        return mockRepository.findAll()
                .stream()
                .map(movieEntity -> {
                    return new MovieDto(movieEntity.getTitle());
                })
                .collect(Collectors.toList());
    }

    public MovieDto findByTitle(String movieTitle) {
        MovieEntity foundMovie = mockRepository.findByTitle(movieTitle);
        System.out.println("service method return entity " + foundMovie.getDirector());
        System.out.println("service method return titles " + foundMovie.getTitle());
        return new MovieDto(foundMovie.getTitle(), foundMovie.getDirector(),
                foundMovie.getActors(), foundMovie.getRelease(), foundMovie.getDescription(),
                foundMovie.getRatings());
    }

}
