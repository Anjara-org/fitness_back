package org.app.fitness_app.Service;

import lombok.AllArgsConstructor;
import org.app.fitness_app.Model.Command;
import org.app.fitness_app.Repository.CommandCrudOp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommandService {
    private CommandCrudOp repository;
    public List<Command> findAll(){
        return repository.findAll();
    }

    public String deleteById(int id){
        repository.deleteById(id);
        return "deleted successfully";
    }
    public Optional<Command> findById(int id){
        return repository.findById(id);
    }

    public Command save(Command command){
        return repository.save(command);
    }
}
