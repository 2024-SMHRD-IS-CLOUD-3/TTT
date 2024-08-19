package com.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.entity.Pose;
import com.smhrd.entity.User;
import com.smhrd.repository.PoseRepository;
import com.smhrd.repository.UserRepository;
import com.smhrd.service.PoseService;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pose")
public class PoseController {

    @Autowired
    private PoseService poseService;

    @Autowired
    private PoseRepository poseRepository;
    
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/processAndSave")
    public ResponseEntity<Map<String, Object>> processAndSavePose(
    		@RequestParam("usr_Id") String usrId,
            @RequestParam("poseImg") MultipartFile image,
            @RequestParam("poseType") String poseType,
            @RequestParam("createdAt") String createdAt) {
    	System.out.println("Received file: " + image.getOriginalFilename());
        System.out.println("Received poseType: " + poseType);
        System.out.println("Received createdAt: " + createdAt);
    	System.out.println(image.isEmpty());
        try {
            // 1. Flask 서버에 이미지 전송 및 처리 결과 받기
            String processedImagePath = poseService.processImage(image, poseType);
            User user = userRepository.findById(usrId)
                    .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 ID입니다. ID: " + usrId));

            // 2. 결과 이미지 및 메타데이터를 DB에 저장
            Pose pose = new Pose();
            pose.setUser(user);  // 실제 사용자 ID를 설정 ->  userID를 세션으로 받아오기
            pose.setPoseImg(processedImagePath);  // 처리된 이미지 경로 설정
            pose.setPoseType(poseType);
            pose.setCreatedAt(Timestamp.from(Instant.parse(createdAt)));
            pose.setFileExt("jpg");  // 

            poseRepository.save(pose);

            // 응답을 위한 Map 객체 생성
            // 보내기 위해서 Map.of를 써야하지만 java9이상에서 사용가능 따라서 Map객체를 해쉬Map으로 생성필요
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);

            return ResponseEntity.ok().body(response);
        } catch (IOException e) {
            // 에러 발생 시 응답에 에러 메시지 포함
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("error","Unexpectied error occured" + e.getMessage());

            return ResponseEntity.status(500).body(response);
        }
    }
}