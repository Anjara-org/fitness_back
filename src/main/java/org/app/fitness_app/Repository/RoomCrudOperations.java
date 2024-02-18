package org.app.fitness_app.Repository;

import org.app.fitness_app.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomCrudOperations extends JpaRepository<Room, Integer> {
}
