package com.smhrd.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

		entity = repo.findByIdAndPw(entity.getId(), entity.getPw());		
		
		session.setAttribute("loginTrainer", entity);
		
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
	public String deleteTrainer(Trainer entity) {
		entity.setId("test3");
		repo.deleteById(entity.getId());
		System.out.println("일단 탈퇴 한번 돌긴함요");
		
		return "redirect:/";
	}

	@PostMapping("/updateTrainer")
	public String updateTrainer(Trainer entity, HttpSession session) {	
		repo.save(entity);
		session.setAttribute("loginTrainer", entity);
		return "redirect:/";
	}
}
