package com.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.Trainer;
import com.smhrd.repository.TrainerRepository;

@Controller
public class TrainerController {
	@Autowired
	private TrainerRepository repo;
	
	@RequestMapping("/loginCheck")
	public String loginCheck(Trainer entity) {
//		TODO#1 로그인 체크 기능
		entity = repo.findByIdAndPw(entity.getId(), entity.getPw());
		
		
//		TODO#1-1 로그인 성공 시 메인화면으로 이동
//		TODO#1-2 로그인 실패 시 홈화면으로 이동
//		메인화면 홈화면 url 같게할 수는 없나?
		return "";
	}
}
