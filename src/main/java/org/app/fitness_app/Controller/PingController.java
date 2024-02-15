package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.app.fitness_app.Service.PingService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PingController {
    PingService pingService;

    public PingController(PingService pingService) {
        this.pingService = pingService;
    }

    @GetMapping("/ping")
    public String ping() {
        return pingService.ping();
    }
}
