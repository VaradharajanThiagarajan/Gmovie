package com.example.Gmovie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    MovieRepository mockRepository;

    @InjectMocks
    MovieService subject;

    @Test
    void create(){
        MovieDto movieDto = new MovieDto("The Avengers");
        subject.create(movieDto);
        verify(mockRepository).save(
                new MovieEntity("The Avengers")
        );
    }
}
