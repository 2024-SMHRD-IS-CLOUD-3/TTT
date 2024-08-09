package com.smhrd.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.User;
import com.smhrd.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@RequestMapping("/goCreateUser")
	public String goCreateUser() {
		return "createUser";
	}
	
	@RequestMapping("/createUser")
	public String createUser(User entity, HttpSession session) {
		
		// 회원정보 추가기능
		System.out.println(entity);
		try {
			
			
			repo.save(entity);// ->insert sql 문장 실행
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// 회원정보 추가 성공시 db tb_user에 회원정보 추가후 회원정보 추가 화면으로
		if(entity != null) {
			System.out.println("Success CreateUser!!!");
			session.setAttribute("createUserInfo", entity);
		}
		// 회원정보 추가 실패시 tb_user에 회원정보 추가 화면으로
		return "createUser";
	}
	
	

}
