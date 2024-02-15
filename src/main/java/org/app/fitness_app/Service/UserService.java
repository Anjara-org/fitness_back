package org.app.fitness_app.Service;

import org.app.fitness_app.Model.User;
import org.app.fitness_app.Model.UserAuthenticate;
import org.app.fitness_app.Repository.UserCrudOperations;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserCrudOperations userCrudOperations;
    private final JwtService jwtService;

    public UserService(UserCrudOperations userCrudOperations, JwtService jwtService) {
        this.userCrudOperations = userCrudOperations;
        this.jwtService = jwtService;
    }
    public User AddNewUser(User user )  {
        return userCrudOperations.save(user);
    }
    public User findByEmail(String email) {
        return userCrudOperations.findByEmail(email);
    }
    public String login(UserAuthenticate request) {
        User userOptional = userCrudOperations.findByEmail(request.getEmail());
        if (userOptional != null) {
            if (request.getPassword().equals(userOptional.getPassword())) {
                return jwtService.generateTokens(userOptional);
            }
        }
        return null;
    }

    public List<User> findAll() {
        return userCrudOperations.findAll();
    }
    public Optional<User> findById(int id) {
        return userCrudOperations.findById(id);
    }
    public User save(User toSave) {
        return userCrudOperations.save(toSave);
    }

    public String deleteById(int id) {
        userCrudOperations.deleteById(id);
        return "User deleted !";
    }
}
