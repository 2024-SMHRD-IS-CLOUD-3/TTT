package com.smhrd.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import com.smhrd.entity.Trainer;
import com.smhrd.repository.TrainerRepository;

@Controller
public class TrainerController {
	
	@Autowired
	private TrainerRepository repo;
	
	@PostMapping("/loginCheck")
	public String loginCheck(Trainer entity, HttpSession session) {

		System.err.println(entity);
		entity = repo.findByIdAndPw(entity.getId(), entity.getPw());		
		
		session.setAttribute("loginTrainer", entity);
		System.err.println(entity);

		if(entity != null) {
			System.out.println("로그인 성공!");
			System.out.println("로그인 info : " + entity.toString());
		}
		return "redirect:/";
	}
	
	
	@PostMapping("/registTrainer")
	public String registTrainer(Trainer entity) {
		
		entity.setToken("hello");
		entity.setType("trainer");
		entity.setJoinedAt(LocalDateTime.now());
		
		entity = repo.save(entity);
		
		if(entity != null) {
			return "redirect:/";
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/deleteTrainer")
	public String deleteTrainer(HttpSession session) {
		Trainer entity = (Trainer)session.getAttribute("loginTrainer");
		
		repo.deleteById(entity.getId());
		
		return "redirect:/";
	}

	@PostMapping("/updateTrainer")
	@Transactional
	public String updateTrainer(Trainer entity, HttpSession session) {
		
		Trainer existingTrainer = (Trainer)session.getAttribute("loginTrainer");
		
		entity.setJoinedAt(existingTrainer.getJoinedAt());
		entity.setType(existingTrainer.getType());
		entity.setProfileImg(existingTrainer.getProfileImg());
		entity.setToken(existingTrainer.getToken());

		existingTrainer = entity;

		if(existingTrainer != null) {
			repo.save(existingTrainer);
			session.setAttribute("loginTrainer", existingTrainer);
		}
		return "redirect:/";
	}
}
