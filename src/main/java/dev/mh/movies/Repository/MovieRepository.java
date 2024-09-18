package dev.mh.movies.Repository;

import dev.mh.movies.Model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //to write the custom queries
    Optional<Movie> findMovieByImdbId(String imdbId);

}
