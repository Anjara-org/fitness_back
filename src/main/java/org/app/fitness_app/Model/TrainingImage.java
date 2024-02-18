package org.app.fitness_app.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.fitness_app.Helper.FileHelper;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "training_image")
public class TrainingImage {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_training_image")
    int idTrainingImage;

    @Column(name = "file_name")
    String fileName;

    @JsonBackReference(value = "training-image")
    @ManyToOne
    @JoinColumn(name = "id_training")
    Training training;

    String imageUrl;

    public String getImageUrl() {
        return FileHelper.getImageUrl(this.fileName);
    }

    public TrainingImage(String fileName, Training training) {
        this.fileName = fileName;
        this.training = training;
    }
}
