package org.app.fitness_app.Controller;

import org.app.fitness_app.Model.User;
import org.app.fitness_app.Model.UserAuthenticate;
import org.app.fitness_app.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {
    private final UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> Register(@RequestBody User user){
        try {
           User newUser = service.AddNewUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserAuthenticate loginRequest) {
        String token = service.login(loginRequest);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Invalid username or password");
        }
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return service.findAll();
    }
    @PutMapping("/users")
    public User save(User toSave) {
        return service.save(toSave);
    }
    @GetMapping("/users/{id}")
    public Optional<User> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteById(id);
    }

}
