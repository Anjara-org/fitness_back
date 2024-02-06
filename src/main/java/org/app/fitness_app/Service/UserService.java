package org.app.fitness_app.Service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.app.fitness_app.Model.User;
import org.app.fitness_app.Repository.UserInterface;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@RequiredArgsConstructor
@Data
@Service
public class UserService {
    private final UserInterface userInterface;
    public User AddNewUser(User user )  {
        return userInterface.save(user);
    }
    public User findByEmail(String email) {
        return userInterface.findByEmail(email);
    }

}
