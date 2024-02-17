package org.app.fitness_app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coach")
public class Coach {
     @Id()
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_coach")
     int Id;
     @Column(name = "coach_name")
     String Name;
     @Column(name = "coach_first_name")
     String firstName;
     @Column(name = "coach_number_phone")
     String numberPhone;
     @ManyToOne
     @JoinColumn(name= "id_room")
     Room room;
}
