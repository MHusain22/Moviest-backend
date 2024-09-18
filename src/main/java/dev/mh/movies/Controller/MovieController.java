package dev.mh.movies.Controller;

import dev.mh.movies.Model.Movie;
import dev.mh.movies.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/movies")
public class MovieController {
    //Reference to Service Class
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.findMovieByImdbId(imdbId), HttpStatus.OK);
    }

    //search movie by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Movie>> getSingleMovies(@PathVariable ObjectId id ) {
//        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
//    }
}
