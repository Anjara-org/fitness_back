package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Training;
import org.app.fitness_app.Service.TrainingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class TrainingController {
    private TrainingService service;

    @GetMapping("/training")
    public List<Training> ShowAllTraining(){
        return service.findAllTraining();
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
