package org.app.fitness_app.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "training")
public class Training {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_training")
    int idTraining;

    @Column(name = "label")
    String label;

    @Column(name = "description")
    String description;

    @JsonManagedReference(value = "training-image")
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "training")
    List<TrainingImage> trainingImages;

}
