package com.smhrd.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainViewController {

	@RequestMapping("/")
	public String goHome(){     
		return "home";
	}

	@RequestMapping("/goLogin")
	public String goLogin() {
		return "login";
	}

	@RequestMapping("/goMain")
	public String goMain() {
		return "main";
	}
	
}
