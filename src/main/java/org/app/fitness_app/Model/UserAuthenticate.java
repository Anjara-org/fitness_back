package org.app.fitness_app.Model;

import lombok.*;
import org.springframework.stereotype.Service;

@Data
@Getter
@Setter
public class UserAuthenticate {
        private String email;
        private String password;
}
