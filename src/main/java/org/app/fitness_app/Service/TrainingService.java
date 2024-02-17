package org.app.fitness_app.Service;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Training;
import org.app.fitness_app.Repository.TrainingCrudOp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrainingService {
    private TrainingCrudOp repository;
    public List<Training> findAllTraining(){
        return repository.findAll();
    }

    public Optional<Training> findById(int id){
        return repository.findById(id);
    }

    public Training save(Training training){
        return repository.save(training);
    }

    public String deleteById(int id){
         repository.deleteById(id);
        return "training deleted ";
    }
}
