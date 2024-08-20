package com.smhrd.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.smhrd.entity.Schedule;
import com.smhrd.entity.Trainer;
import com.smhrd.entity.User;
import com.smhrd.repository.ScheduleRepository;
import com.smhrd.repository.TrainerRepository;
import com.smhrd.repository.UserRepository;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        // 유효성 검사 (예시)
    	System.err.println("DB에 저장 중");
        if (schedule.getStartDate().isAfter(schedule.getEndDate())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        // Trainer와 User 객체를 ID로 조회
        Optional<Trainer> trainerOpt = trainerRepository.findById(schedule.getTrainer().getId());
        Optional<User> userOpt = userRepository.findById(schedule.getUser().getId());

        if (trainerOpt.isPresent() && userOpt.isPresent()) {
            schedule.setTrainer(trainerOpt.get());
            schedule.setUser(userOpt.get());
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule updatedSchedule) {
        Optional<Schedule> existingScheduleOpt = scheduleRepository.findById(id);

        if (existingScheduleOpt.isPresent()) {
            Schedule existingSchedule = existingScheduleOpt.get();

            // 요청의 ID와 PathVariable ID가 일치하는지 확인
            if (!updatedSchedule.getId().equals(id)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            // 유효성 검사
            if (updatedSchedule.getStartDate().isAfter(updatedSchedule.getEndDate())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            // Trainer와 User 객체를 ID로 조회
            Optional<Trainer> trainerOpt = trainerRepository.findById(updatedSchedule.getTrainer().getId());
            Optional<User> userOpt = userRepository.findById(updatedSchedule.getUser().getId());

            if (trainerOpt.isPresent() && userOpt.isPresent()) {
                existingSchedule.setTrainer(trainerOpt.get());
                existingSchedule.setUser(userOpt.get());
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            existingSchedule.setDescription(updatedSchedule.getDescription());
            existingSchedule.setStartDate(updatedSchedule.getStartDate());
            existingSchedule.setStartTime(updatedSchedule.getStartTime());
            existingSchedule.setEndDate(updatedSchedule.getEndDate());
            existingSchedule.setEndTime(updatedSchedule.getEndTime());
            existingSchedule.setColor(updatedSchedule.getColor());
            existingSchedule.setStatus(updatedSchedule.getStatus());

            Schedule savedSchedule = scheduleRepository.save(existingSchedule);
            return new ResponseEntity<>(savedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        if (scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @GetMapping
    public ResponseEntity<List<Schedule>> getSchedulesForLoggedInTrainer(HttpSession session) {
        try {
            // 세션에서 로그인된 트레이너 정보 가져오기
            Trainer loggedInTrainer = (Trainer) session.getAttribute("loginTrainer");
            
            if (loggedInTrainer == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // 로그인된 트레이너가 없으면 401 응답
            }

            // 해당 트레이너와 관련된 스케줄 조회
            List<Schedule> schedules = scheduleRepository.findByTrainer(loggedInTrainer);

            return new ResponseEntity<>(schedules, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/user")
    public ResponseEntity<List<Schedule>> getUserSchedules(@RequestParam("userId") String userId) {
        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isPresent()) {
            List<Schedule> schedules = scheduleRepository.findByUser(userOpt.get());
            return new ResponseEntity<>(schedules, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    


}

