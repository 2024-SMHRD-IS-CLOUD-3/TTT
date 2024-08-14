package com.smhrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainViewController {

	@GetMapping("/")
	public String goHome(){     
		return "home";
	}

	@GetMapping("/goLogin")
	public String goLogin() {
		return "login";
	}

	@GetMapping("/goMain")
	public String goMain() {
		return "scheduleManagement";
	}
	
	@GetMapping("/goMyPage")
	public String goMyPage() {
		return "myPage";
	}
	
	@GetMapping("/goManagePage")
	public String goManagePage() {
		return "membershipManagement";
	}
	
	@GetMapping("/goMemberSchedule")
	public String goMemberSchedule() {
		return "memberSchedule";
	}
}
