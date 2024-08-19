package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Trainer;
import com.smhrd.entity.User;
import com.smhrd.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserRequestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUsers(HttpSession session) {
    	Trainer trainer = (Trainer)session.getAttribute("loginTrainer");
        List<User> users = userRepository.findByTrainer(trainer);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
