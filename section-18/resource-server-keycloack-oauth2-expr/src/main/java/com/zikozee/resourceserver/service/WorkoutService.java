package com.zikozee.resourceserver.service;

import com.zikozee.resourceserver.model.Workout;
import com.zikozee.resourceserver.repository.WorkoutRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Ezekiel Eromosei
 * @created: 20 March 2022
 */

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @PreAuthorize("#workout.user == authentication.name and #oauth2.hasScope('fitnessapp')") // todo info: for oauth2 epr
    public void saveWorkout(Workout workout){
        workoutRepository.save(workout);
    }

    public List<Workout> findWorkouts(){  // we have already added filtering at the repo layer
        return workoutRepository.findAllByUser();
    }

    public void deleteWorkout(Integer id){
        workoutRepository.deleteById(id);
    }
}
