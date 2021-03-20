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
        mockRepository.save(
                new MovieEntity(movieDto.getTitle())
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

}
