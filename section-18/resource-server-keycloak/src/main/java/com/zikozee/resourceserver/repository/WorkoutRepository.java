package com.zikozee.resourceserver.repository;

import com.zikozee.resourceserver.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: Ezekiel Eromosei
 * @created: 20 March 2022
 */

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

    @Query(value = "SELECT w FROM Workout w WHERE w.user = ?#{authentication.name}")
    List<Workout> findAllByUser();
}
