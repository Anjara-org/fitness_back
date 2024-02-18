package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Training;
import org.app.fitness_app.Service.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
public class TrainingController {
    private TrainingService service;

    @GetMapping("/training")
    public List<Training> ShowAllTraining(){
        return service.findAllTraining();
    }

    @GetMapping("/training/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id){
        Optional<Training> training = service.findById(id);
        return training.<ResponseEntity<Object>>map(
                value -> new ResponseEntity<>(value, HttpStatus.OK)
        ).orElseGet(
                () -> ResponseEntity.ok("Training not found")
        );
    }

    @PostMapping("/training")
    public Training AddTraining(@RequestBody  Training training){
        return service.save(training);
    }

    @DeleteMapping("/training/{id}")
    public String DeletedById(@PathVariable int id){
        return service.deleteById(id);
    }
}
