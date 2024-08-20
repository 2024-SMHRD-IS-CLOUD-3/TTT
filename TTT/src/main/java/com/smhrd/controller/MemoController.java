package com.smhrd.controller;

import com.smhrd.entity.Memo;
import com.smhrd.entity.User;
import com.smhrd.repository.MemoRepository;
import com.smhrd.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.security.Timestamp;
import java.util.ArrayList;

@Controller
public class MemoController {

   @Autowired
   private MemoRepository memoRepository;
   
   @Autowired
   private UserRepository userRepository;

   @RequestMapping("/goMemo")
   public String goMemo(Model model, @RequestParam("userId") String userId) {
	  System.out.println(userId);
	  Optional<User> userOptional = userRepository.findById(userId);
	  
	  if (userOptional.isPresent()) {
		  User user = userOptional.get();
		  model.addAttribute("memoUser",user);
	  }
	  
      ArrayList<Memo> memoList = (ArrayList<Memo>) memoRepository.findAllByUserId(userId);
      
      
      
      if (memoList.isEmpty()) {
          model.addAttribute("memoList", new ArrayList<>());
       } else {
    	  model.addAttribute("memoList", memoList);
       }

       return "userMemo";
   }
   
//
   
   @PostMapping("/createMemo")
   public ResponseEntity<Map<String, Object>> createMemo(@RequestBody Map<String, Object> memoData) {
       
	   String userId = (String) memoData.get("userId");
	   String memoContent = (String) memoData.get("memoContent");
	   String createdAt = (String) memoData.get("createdAt");
	   
	   Optional<User> userOptional = userRepository.findById(userId);
	   System.out.println("여기는 createMemo"+userId);
	   
	   if (userOptional.isPresent()) {
	        Memo memo = new Memo();
	        memo.setUser(userOptional.get());
	        memo.setMemoContent(memoContent);

	        Memo savedMemo = memoRepository.save(memo);
	        Map<String, Object> response = new HashMap<>();
	        response.put("success", true);
	        response.put("memoIdx", savedMemo.getMemoIdx());
	        return ResponseEntity.ok().body(response);
	    } else {
	        Map<String, Object> response = new HashMap<>();
	        response.put("success", false);
	        response.put("message", "유효하지 않은 사용자 ID입니다.");
	        return ResponseEntity.status(400).body(response);
	    }
   }
	    

   
   @PutMapping("/updateMemo/{memoIdx}")
   public ResponseEntity<Map<String, Object>> updateMemo(@PathVariable Long memoIdx, @RequestBody Memo memoDetails) {
       return memoRepository.findById(memoIdx).map(memo -> {
           // Memo 객체의 내용 수정
           memo.setMemoContent(memoDetails.getMemoContent());
           memo.setCreatedAt(memoDetails.getCreatedAt()); // 필요시 수정
           
           // 수정된 Memo 객체를 저장
           Memo updatedMemo = memoRepository.save(memo);
           
           // 응답으로 사용할 Map 생성
           Map<String, Object> response = new HashMap<>();
           response.put("success", true);
           response.put("updatedMemo", updatedMemo);
           
           // ResponseEntity로 반환
           return ResponseEntity.ok().body(response);
       }).orElse(ResponseEntity.notFound().build());
   }
//
//
//
   @DeleteMapping("/deleteMemo/{memoIdx}")
   public ResponseEntity<?> deleteMemo(@PathVariable Long memoIdx) {
       return memoRepository.findById(memoIdx).map(memo -> {
           memoRepository.delete(memo);
           return ResponseEntity.ok().build();
       }).orElse(ResponseEntity.notFound().build());
   }

}
