package dev.mh.movies.Service;

import dev.mh.movies.Repository.UserRepository;
import dev.mh.movies.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Check if email or username is already taken
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }
        return user;
    }
}
