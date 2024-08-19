package com.smhrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/goUserManagePage")
	public String goManagePage() {
		return "userManagement";
	}
	
	
	@GetMapping("/goUserRegistration")
	public String goUserRegistration() {
		return "userRegistration";
	}
	
	@GetMapping("/goUserDetail")
	public String goUserModify() {
		return "userDetail";
	}
	
	
}
