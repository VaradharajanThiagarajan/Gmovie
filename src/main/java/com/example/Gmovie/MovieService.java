package com.example.Gmovie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?>  findByTitle(String movieTitle) {
        MovieEntity foundMovie = mockRepository.findByTitle(movieTitle);

        if(foundMovie != null) {
//            return new MovieDto(foundMovie.getTitle(), foundMovie.getDirector(),
//                    foundMovie.getActors(), foundMovie.getRelease(), foundMovie.getDescription(),
//                    foundMovie.getRatings());
            return new ResponseEntity<MovieEntity>(foundMovie, HttpStatus.OK);
        }

        MovieMessage message1 = new MovieMessage();
        message1.message = "movie does not exist";
        return new ResponseEntity<MovieMessage>(message1, HttpStatus.NOT_FOUND);

    }

}
