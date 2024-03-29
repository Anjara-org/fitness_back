package org.app.fitness_app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coach")
public class Coach implements Serializable {
     @Id()
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_coach")
     int idCoach;

     @Column(name = "coach_name")
     String Name;

     @Column(name = "coach_first_name")
     String firstName;

     @Column(name = "coach_number_phone")
     String numberPhone;

}
