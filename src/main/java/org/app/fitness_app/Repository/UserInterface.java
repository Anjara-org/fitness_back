package org.app.fitness_app.Repository;

import org.app.fitness_app.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInterface extends JpaRepository<User, Integer> {
    public User findByEmail(String email);

}
