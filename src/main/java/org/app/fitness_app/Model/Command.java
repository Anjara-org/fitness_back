package org.app.fitness_app.Model;

import ch.qos.logback.classic.pattern.DateConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@Table(name = "command")
public class Command {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_command")
    int id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    User user;

    @ManyToOne
    @JoinColumn(name = "id_training")
    Training training;

    @Column(name = "created_date", nullable = false)
    Date createdDate;

    @Column(name = "modified_date")
    Date modified_date;

    @ManyToOne
    @JoinColumn(name = "id_coach")
    Coach coach;

    public Command(int id, User user, Training training, Date createdDate, Date modified_date, Coach coach) {
        this.id = id;
        this.user = user;
        this.training = training;
        this.createdDate = new Date();
        this.modified_date = modified_date;
        this.coach = coach;
    }
}
