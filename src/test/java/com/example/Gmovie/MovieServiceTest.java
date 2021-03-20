package com.example.Gmovie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    MovieRepository mockRepository;

    @InjectMocks
    MovieService subject;

    @Test
    void create() {
        MovieDto movieDto = new MovieDto("The Avengers");
        subject.create(movieDto);
        verify(mockRepository).save(
                new MovieEntity("The Avengers")

        );
    }

    @Test
    void fetchAllTest() {
        MovieEntity movieEntity1 = new MovieEntity("The Avengers");
        MovieEntity movieEntity2 = new MovieEntity("Superman Returns");
        List<MovieEntity> listveri = new ArrayList<MovieEntity>();

        when(mockRepository.findAll()).thenReturn(listveri);


        MovieDto movieDto1 = new MovieDto("The Avengers");
        MovieDto movieDto2 = new MovieDto("Superman Returns");
        List<MovieDto> listveri1 = new ArrayList<MovieDto>();
        listveri.add(movieEntity1);
        listveri.add(movieEntity2);

        listveri1.add(movieDto1);
        listveri1.add(movieDto2);

        List<MovieDto> movieDto = subject.fetchAll();


        assertThat(movieDto).isEqualTo(listveri1);
    }
}