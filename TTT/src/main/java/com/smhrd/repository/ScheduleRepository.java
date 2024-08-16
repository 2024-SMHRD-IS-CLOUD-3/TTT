package com.smhrd.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smhrd.entity.Schedule;
import com.smhrd.entity.Trainer;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // 기본 CRUD 메서드를 JpaRepository가 제공
	List<Schedule> findByTrainer(Trainer trainer);
}
