package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.app.fitness_app.Service.PingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor
public class PingController {
    PingService pingService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok(pingService.ping());
    }
}
