package org.app.fitness_app.Repository;

import org.app.fitness_app.Model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandCrudOp extends JpaRepository<Command, Integer> {
}
