package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Room;
import org.app.fitness_app.Service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@AllArgsConstructor
public class RoomController {
    private RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }
    @GetMapping("/rooms/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Optional<Room> room = roomService.findById(id);
        return room.<ResponseEntity<Object>>map(
                value -> new ResponseEntity<>(value, HttpStatus.OK)
        ).orElseGet(
                () -> ResponseEntity.ok("Room not found")
        );
    }
    @PutMapping("/rooms")
    public ResponseEntity<Room> save(@RequestBody Room toSave) {
        return ResponseEntity.ok(roomService.save(toSave));
    }
    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok(roomService.delete(id));
    }
}
