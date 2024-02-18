package org.app.fitness_app.Service;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Helper.FileHelper;
import org.app.fitness_app.Model.Training;
import org.app.fitness_app.Model.TrainingImage;
import org.app.fitness_app.Repository.TrainingImagesCrudOperations;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrainingImageService {
    private TrainingImagesCrudOperations repository;
    public List<TrainingImage> findAllTrainingImage() {
        return repository.findAll();
    }

    public TrainingImage store(MultipartFile file, Training training) throws IOException {
        // copy image file into resource/images
        FileCopyUtils.copy(file.getBytes(), new File(FileHelper.getAbsolutePathImage(file.getOriginalFilename())));
        // save to the database
        TrainingImage trainingImage = new TrainingImage(file.getOriginalFilename(), training);

        return  repository.save(trainingImage);
    }

    public Optional<TrainingImage> findById(int id){
        return repository.findById(id);
    }

    public String deleteById(int id){
        repository.deleteById(id);
        return "Image deleted " ;
    }
}
