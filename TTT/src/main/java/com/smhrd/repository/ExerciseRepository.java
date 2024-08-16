package com.smhrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
   
}
