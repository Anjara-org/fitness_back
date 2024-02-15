package org.app.fitness_app.Service;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class PingService {
    public String ping() {
        return "Pong !";
    }
}
