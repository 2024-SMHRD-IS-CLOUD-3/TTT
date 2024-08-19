package com.smhrd.controller;

import com.smhrd.entity.Memo;
import com.smhrd.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

import java.util.ArrayList;

@Controller
public class MemoController {

   @Autowired
   private MemoRepository memoRepository;

   @RequestMapping("/goMemo")
   public String goMemo(Model model, @RequestParam("userId") String userId) {
      ArrayList<Memo> memoList = (ArrayList<Memo>) memoRepository.findAllByUserId(userId);
      model.addAttribute("memoList", memoList);
      
      if (!memoList.isEmpty()) {
          System.out.println(memoList.get(0));
       } else {
          System.out.println("메모가 존재하지 않습니다.");
       }

       return "userMemo";
   }
   
//
   
   @PostMapping("/createMemo")
   public ResponseEntity<Map<String, Object>> createMemo(@RequestBody Memo memo) {
       Memo savedMemo = memoRepository.save(memo);
       Map<String, Object> response = new HashMap<>();
       response.put("success", true);
       response.put("memoIdx", savedMemo.getMemoIdx());
       return ResponseEntity.ok().body(response);
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
