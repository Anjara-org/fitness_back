package org.app.fitness_app.Repository;

import org.app.fitness_app.Model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingCrudOp extends JpaRepository<Training, Integer> {
}
