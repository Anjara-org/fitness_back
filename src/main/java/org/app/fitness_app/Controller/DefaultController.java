package org.app.fitness_app.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DefaultController {

    @GetMapping("/")
    public ResponseEntity<String> noResource(){
        return ResponseEntity.ok("No resource found");
    }
    @GetMapping("*")
    public ResponseEntity<String> notFound(){
        return ResponseEntity.ok("Path not found");
    }
}
