package org.app.fitness_app.Repository;

import org.app.fitness_app.Model.TrainingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingImagesCrudOperations extends JpaRepository<TrainingImage, Integer> {
}
