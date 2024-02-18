package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Training;
import org.app.fitness_app.Model.TrainingImage;
import org.app.fitness_app.Service.TrainingImageService;
import org.app.fitness_app.Service.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
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
    @GetMapping("/training/{id}/images")
    public ResponseEntity<List<TrainingImage>> findAll(@PathVariable int trainingId) {
        return ResponseEntity.ok(service.findAllTrainingImage());
    }
    /*@GetMapping("/training/{trainingId}/images/{imageId}")
    public ResponseEntity<List<TrainingImage>> findAll(@PathVariable int trainingId, @PathVariable int imageId) {
        return null;
    }*/
}
