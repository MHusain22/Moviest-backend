package dev.mh.movies.Service;

import dev.mh.movies.Model.Movie;
import dev.mh.movies.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    //Reference of the MovieRepository
    @Autowired //To instantiate this class (works like constructor)
    private MovieRepository movieRepository;
    //Database Access Methods
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }


}
