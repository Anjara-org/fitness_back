package org.app.fitness_app.Model;

import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Data
public class UserAuthenticate implements Serializable {
        private String email;
        private String password;
}
