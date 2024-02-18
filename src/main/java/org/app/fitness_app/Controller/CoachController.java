package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Coach;
import org.app.fitness_app.Service.CoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@AllArgsConstructor
public class CoachController {
    private  CoachService service;
    @GetMapping("/coaches")
    public List<Coach> findAllCoach() {
        return service.findAll();
    }
    @GetMapping("/coaches/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Optional<Coach> coach = service.findById(id);
        return coach.<ResponseEntity<Object>>map(
                value -> new ResponseEntity<>(value, HttpStatus.OK)
        ).orElseGet(
                () -> ResponseEntity.ok("Coach not found")
        );
    }
    @PutMapping("/coaches")
    public ResponseEntity<Coach> save(@RequestBody Coach toSave) {
        return ResponseEntity.ok(service.save(toSave));
    }
    @PutMapping("/coaches/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
