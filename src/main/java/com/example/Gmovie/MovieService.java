package com.example.Gmovie;

import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository mockRepository;

    MovieService(MovieRepository mockRepository){
        this.mockRepository = mockRepository;

    }
    public void create(MovieDto movieDto){
        mockRepository.save(
                new MovieEntity(movieDto.getTitle())
        );

    }

}
