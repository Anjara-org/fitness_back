package org.app.fitness_app.Controller;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Coach;
import org.app.fitness_app.Service.CoachService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class CoachController {
    private  CoachService service;
    @GetMapping("/coach")
    public List<Coach> findAllCoach(@PathVariable  int idRoom) {
        return service.findCoachByIdRoom(idRoom);
    }


}
