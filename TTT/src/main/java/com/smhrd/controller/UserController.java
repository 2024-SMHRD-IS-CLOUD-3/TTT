package com.smhrd.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.entity.Exercise;
import com.smhrd.entity.Trainer;
import com.smhrd.entity.User;
import com.smhrd.repository.ExerciseRepository;
import com.smhrd.repository.UserRepository;
import com.smhrd.repository.UserWithLatestCountDTO;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/registUser")
	public String registUser(User entity, HttpSession session) {
		
		// 회원정보 추가전 entity값 확인
		System.out.println(entity);
		System.out.println("넘어오긴 옴");
		try {
			entity.setId("");
			entity.setJoinedAt(LocalDateTime.now());
			entity.setProfileImg("/resources/image/default_profile.jpg");
			entity.setTrainer((Trainer)session.getAttribute("loginTrainer"));
			userRepository.save(entity);// ->insert sql 문장 실행

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(entity);

		// 회원정보 추가 성공시 db tb_user에 회원정보 추가후 회원정보 추가 화면으로
		if (entity != null) {
			System.out.println("Success CreateUser!!!");
		}
		// 회원정보 추가 실패시 tb_user에 회원정보 추가 화면으로
		return "redirect:/selectUser";
	}

	
	// 유저관리 페이지를 출력하기 위한 userList 저장
	@RequestMapping("/selectUser")
	public String selectUser(Model model) {
		
		// 저장되어있는 내용이 있다면 해당 내용들을 리스트로 출력!
		try {
			ArrayList<UserWithLatestCountDTO> userList = userRepository.findAllUsersWithLatestCount(); // -> SQL 문장 실행

			// Optional: 첫 번째 유저의 이름을 로그로 출력 (데이터가 존재하는지 확인)
			if (!userList.isEmpty()) {
				System.out.println(userList.get(0));
				System.out.println("First user name: " + userList.get(0).getUsr_Name());
				System.out.println("First user name: " + userList.get(0).getUsr_Id());
				System.out.println("First user name: " + userList.get(0).getUsr_Birthdate());
				System.out.println("First user name: " + userList.get(0).getCount());
			}

			// 모델에 데이터 추가
			model.addAttribute("userList", userList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userManagement";
	}

	@RequestMapping("/goDetailUser")
	public String goDetailUser(@RequestParam("urId") String urId, Model model) {
		User entity = userRepository.findById(urId).get();
		model.addAttribute("user", entity);

		return "detailUser";
	}

	@RequestMapping("/goModifyUser")
	public String goModifyUser(@RequestParam("urId") String id, User entity, Model model) {
		User existEntity = userRepository.findById(id).get();
		System.out.println(existEntity);
		existEntity.setGender(entity.getGender());
		existEntity.setPhone(entity.getPhone());
		existEntity.setAddress(entity.getAddress());
		existEntity.setHeight(entity.getHeight());
		existEntity.setWeight(entity.getWeight());
		userRepository.save(existEntity);
		entity = userRepository.findById(id).get();
		model.addAttribute("user", entity);
		System.out.println(entity);

		return "redirect:/userList";
	}

	@RequestMapping("/goDeleteUser")
	public String goDeleteUser(@RequestParam("urId") String urId) {
		userRepository.deleteById(urId);

		return "redirect:/userList";
	}

}
