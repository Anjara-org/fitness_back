package org.app.fitness_app.Service;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Room;
import org.app.fitness_app.Repository.RoomCrudOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoomService {
    RoomCrudOperations roomCrudOperations;

    public List<Room> findAll() {
        return roomCrudOperations.findAll();
    }
    public Optional<Room> findById(int id) {
        return roomCrudOperations.findById(id);
    }
    public Room save(Room toSave) {
        return roomCrudOperations.save(toSave);
    }
    public String delete(int id) {
        roomCrudOperations.deleteById(id);
        return "Room deleted";
    }
}
