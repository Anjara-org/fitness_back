package org.app.fitness_app.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestCiCdController {
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test passed !");
    }
}
