package dev.mh.movies.Repository;

import dev.mh.movies.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}