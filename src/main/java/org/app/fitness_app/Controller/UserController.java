package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.app.fitness_app.Model.User;
import org.app.fitness_app.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
@Data
public class UserController {
    private UserService userService;
    @PostMapping
    public User InsertNewUser(User user) throws SQLException {
        return userService.AddNewUser(user);
    }
}
