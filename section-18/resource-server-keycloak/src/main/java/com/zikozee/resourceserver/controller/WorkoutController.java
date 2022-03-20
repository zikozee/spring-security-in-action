package com.zikozee.resourceserver.controller;

import com.zikozee.resourceserver.model.Workout;
import com.zikozee.resourceserver.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Ezekiel Eromosei
 * @created: 20 March 2022
 */

@RestController
@RequestMapping(path = "workout")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public void add(@RequestBody Workout workout){
        workoutService.saveWorkout(workout);
    }

    @GetMapping
    public List<Workout> findAll(){
        return workoutService.findWorkouts();
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        workoutService.deleteWorkout(id);
    }
}
