package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.app.fitness_app.Model.User;
import org.app.fitness_app.Model.UserAuthenticate;
import org.app.fitness_app.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@Data
public class UserController {
    private UserService service;
    @PostMapping("/signIn")
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
}
