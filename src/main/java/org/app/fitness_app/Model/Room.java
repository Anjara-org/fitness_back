package org.app.fitness_app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.fitness_app.Model.EnumType.Equipments;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class Room {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_room")
    int id;
    @Column(name = "room_equipment")
    @Enumerated(EnumType.STRING)
    Equipments roomEquipment;
    @Column(name = "room_localisation")
    String localisation;
}
