package com.smhrd.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String createUser(User entity) {
		
		// 회원정보 추가전 entity값 확인
		System.out.println(entity);
		try {
			
			
			repo.save(entity);// ->insert sql 문장 실행
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// 회원정보 추가 성공시 db tb_user에 회원정보 추가후 회원정보 추가 화면으로
		if(entity != null) {
			System.out.println("Success CreateUser!!!");
		}
		// 회원정보 추가 실패시 tb_user에 회원정보 추가 화면으로
		return "redirect:/userList";
	}
	@RequestMapping("/goManageUser")
	public String goMagageUser() {
		return "manageUser";
	}
	
	// 유저관리 페이지를 출력하기 위한 userList  저장
	@RequestMapping("/userList")
	public String manageUser(Model model) {
		// 저장되어있는 내용이 있다면 해당 내용들을 리스트로 출력!
		ArrayList<User> userList= (ArrayList<User>)repo.findAll();
		
		
		model.addAttribute("userList", userList);
		return "manageUser";
	}
	
	@RequestMapping("/goDetailUser")
	public String goDetailUser(@RequestParam("urId") String urId, Model model) {
		User entity = repo.findById(urId).get();
		model.addAttribute("user",entity);
		
		return "detailUser";
	}
	
	@RequestMapping("/goModifyUser")
	public String goModifyUser(@RequestParam("urId") String urId, User entity, Model model) {
		User existEntity = repo.findById(urId).get();
		System.out.println(existEntity);
		existEntity.setUrGender(entity.getUrGender());
		existEntity.setUrPhone(entity.getUrPhone());
		existEntity.setUrAddress(entity.getUrAddress());
		existEntity.setUrHeight(entity.getUrHeight());
		existEntity.setUrWeight(entity.getUrWeight());
		repo.save(existEntity);
		entity = repo.findById(urId).get();
		model.addAttribute("user", entity);
		System.out.println(entity);
		
		return "redirect:/userList";
	}
	
	@RequestMapping("/goDeleteUser")
	public String goDeleteUser(@RequestParam("urId") String urId) {
	repo.deleteById(urId);
		
		
		return "redirect:/userList";
	}

	

}
