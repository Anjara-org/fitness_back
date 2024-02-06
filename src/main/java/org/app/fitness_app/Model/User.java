package org.app.fitness_app.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {
    @Column
    @Id
     int id;
    @Column
     String name;
    @Column
     String firstName;
    @Column
     String email;
    @Column
     String password;

}
