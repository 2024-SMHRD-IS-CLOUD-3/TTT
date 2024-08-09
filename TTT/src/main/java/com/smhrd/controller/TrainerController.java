package com.smhrd.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.smhrd.entity.Trainer;
import com.smhrd.repository.TrainerRepository;

@Controller
public class TrainerController {
	
	@Autowired
	private TrainerRepository repo;
	private Trainer loginEntity;

	
	@PostMapping("/loginCheck")
	public String loginCheck(Trainer entity) {

		this.loginEntity = repo.findByIdAndPw(entity.getId(), entity.getPw());		
		
		if(loginEntity != null) {
			System.out.println("로그인 성공!");
			System.out.println("로그인 info : " + loginEntity.toString());
			return "redirect:/";
		}
		System.err.println("로그인 실패");
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
		System.err.println("회원가입 실패");
		
		return "redirect:/";
	}
	
	@GetMapping("/deleteTrainer")
	public String deleteTrainer() {
		System.err.println("탈퇴 전 : " + loginEntity);
		repo.deleteById(loginEntity.getId());
		System.err.println("탈퇴 후 : " + repo.findById(loginEntity.getId()));
		
		return "redirect:/";
	}

	@PostMapping("/goMyPage")
	public String goMyPage() {
		if(loginEntity != null)
			return "myPage";
		System.out.println("로그인 하고 오셈요");
		return "redirect:/";
	}
}
