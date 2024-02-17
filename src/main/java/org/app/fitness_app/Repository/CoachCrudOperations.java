package org.app.fitness_app.Repository;

import org.app.fitness_app.Model.Coach;
import org.app.fitness_app.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoachCrudOperations extends JpaRepository<Coach, Integer> {

}
