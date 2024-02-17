package org.app.fitness_app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "command")
public class Command {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_command")
    int id;

    @ManyToOne
    @JoinColumn(name = "id_coach")
    Coach coach;

}
