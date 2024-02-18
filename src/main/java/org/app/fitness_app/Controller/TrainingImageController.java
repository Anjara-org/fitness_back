package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Training;
import org.app.fitness_app.Model.TrainingImage;
import org.app.fitness_app.Service.TrainingImageService;
import org.app.fitness_app.Service.TrainingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin

public class TrainingImageController {

    private TrainingImageService service;
    private TrainingService trainingService;

    @PostMapping("/training/{id}/image")
    public String uploadFile( @RequestParam("file") MultipartFile file, @PathVariable int id ) throws IOException {
        Optional<Training> training = trainingService.findById(id);
        service.store(file, training.get());
        return "uploaded successfully";
    }
}
