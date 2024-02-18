package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Command;
import org.app.fitness_app.Service.CommandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@AllArgsConstructor
public class CommandController {
    private CommandService service;
    @GetMapping("/commands")
    public List<Command> ShowAllCommand(){
        return service.findAll();
    }

    @PostMapping("/commands")
    public Command save(@RequestBody Command command){
        return service.save(command);
    }

    @GetMapping("/commands/{id}")
    public Optional<Command> findCommand(@PathVariable int id){
        return service.findById(id);
    }

    @DeleteMapping("/commands/{id}")
    public String deletedById(@PathVariable int id){
        return service.deleteById(id);
    }
}
