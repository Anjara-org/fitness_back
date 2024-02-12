package org.app.fitness_app.Service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.app.fitness_app.Model.User;
import org.app.fitness_app.Model.UserAuthenticate;
import org.app.fitness_app.Repository.UserInterface;
import org.app.fitness_app.Security.JwtService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserInterface userInterface;
    private final JwtService jwtService;
    public User AddNewUser(User user )  {
        return userInterface.save(user);
    }
    public User findByEmail(String email) {
        return userInterface.findByEmail(email);
    }
    public String login(UserAuthenticate request) {
        User userOptional = userInterface.findByEmail(request.getEmail());
        if (userOptional != null) {
            User user = userOptional;
            if (request.getPassword().equals(user.getPassword())) {
                return jwtService.generateTokens(user);
            }
        }
        return null;
    }

}
