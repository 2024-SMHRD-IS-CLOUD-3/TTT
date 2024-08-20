package com.smhrd.controller;

import java.time.LocalDateTime;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.smhrd.entity.Trainer;
import com.smhrd.repository.TrainerRepository;

@Controller
public class TrainerController {
	
	@Autowired
	private TrainerRepository repo;
	
    @PostMapping("/loginCheck")
    public String loginCheck(Trainer entity, HttpSession session, Model model) {

        System.err.println(entity);
        entity = repo.findByIdAndPw(entity.getId(), entity.getPw());        
        
        if(entity != null) {
            System.out.println("로그인 성공!");
            System.out.println("로그인 info : " + entity.toString());
            session.setAttribute("loginTrainer", entity); // 로그인한 Trainer 객체를 세션에 저장
            return "redirect:/"; // 홈 화면으로 리다이렉트
        } else {
            System.out.println("로그인 실패!");
            model.addAttribute("loginError", "Invalid username or password.");
            return "login"; // 로그인 페이지로 다시 리다이렉트
        }
    }


	
	@PostMapping("/registTrainer")
	public String registTrainer(Trainer entity, Model model) {
		
		entity.setToken("hello");
		entity.setType("trainer");
		entity.setJoinedAt(LocalDateTime.now());
		entity.setProfileImg("resources/image/default_profile.png");
		entity = repo.save(entity);
		
		if(entity != null) {
			return "redirect:/";
		}
		System.err.println("회원가입 실패");
		
		return "redirect:/";
	}
	
	@RequestMapping("/deleteTrainer")
	public String deleteTrainer(HttpSession session) {
		Trainer entity = (Trainer)session.getAttribute("loginTrainer");
		
		repo.deleteById(entity.getId());

		if(entity != null) {
			session.invalidate(); // 세션 무효화
		}
		

		return "redirect:/";
	}

	@PostMapping("/updateTrainer")
	@Transactional
	public String updateTrainer(Trainer entity, HttpSession session) {
		
		Trainer existingTrainer = (Trainer)session.getAttribute("loginTrainer");
		
		existingTrainer.setBirthdate(entity.getBirthdate());
		existingTrainer.setPw(entity.getPw());
		existingTrainer.setProfileImg(entity.getProfileImg());
		existingTrainer.setEmail(entity.getEmail());
		existingTrainer.setPhone(entity.getPhone());

		if(existingTrainer != null) {
			repo.save(existingTrainer);
			session.setAttribute("loginTrainer", existingTrainer);
			session.invalidate(); // 세션 무효화
		}
		
		return "redirect:/";
	}
	
	
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/";  // 홈 화면으로 리다이렉트
    }

}
