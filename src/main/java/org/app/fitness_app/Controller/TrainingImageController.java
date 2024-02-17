package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Training;
import org.app.fitness_app.Model.TrainingImage;
import org.app.fitness_app.Service.TrainingImageService;
import org.app.fitness_app.Service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
