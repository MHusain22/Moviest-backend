package dev.mh.movies.Controller;
import dev.mh.movies.Model.User;
import dev.mh.movies.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register with username, email, and password
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Login with email and password
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        try {
            userService.loginUser(user.getEmail(), user.getPassword());
            return ResponseEntity.ok("Login successful");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
