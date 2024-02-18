package org.app.fitness_app.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegister implements Serializable {
    private String name;
    private String firstName;
    private String email;
    private String password;
}
