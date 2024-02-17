package org.app.fitness_app.Repository;

import org.app.fitness_app.Model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachCrudOperations extends JpaRepository<Coach, Integer> {

}
