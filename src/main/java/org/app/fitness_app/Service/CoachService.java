package org.app.fitness_app.Service;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Coach;
import org.app.fitness_app.Model.Room;
import org.app.fitness_app.Repository.CoachCrudOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class CoachService {
    private CoachCrudOperations coachCrudOperations;
    public List<Coach> findAll(){
        return coachCrudOperations.findAll();
    }


    public Optional<Coach> findById(int id) {
        return coachCrudOperations.findById(id);
    }

    public Coach save(Coach toSave) {
        return coachCrudOperations.save(toSave);
    }
}
