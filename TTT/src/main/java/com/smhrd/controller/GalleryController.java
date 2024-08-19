package com.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.smhrd.entity.Pose;
import com.smhrd.entity.User;
import com.smhrd.repository.PoseRepository;
import com.smhrd.repository.UserRepository;

@Controller
@RequestMapping("/pose")
public class GalleryController {

	@Autowired
	private PoseRepository poseRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/Gallery")
	public String showGallery(@RequestParam("userId") String user_Id, Model model) {
		Optional<User> userOptional = userRepository.findById(user_Id);

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			model.addAttribute("poseUser", user);
			
			
			// 해당 User에 관련된 모든 Pose 조회
			ArrayList<Pose> poses = (ArrayList<Pose>) poseRepository.findAllByUser(user);
			
			if (poses.isEmpty()) {
				model.addAttribute("poses", new ArrayList<>());
			} else {

				for (Pose pose : poses) {
					String originalPath = pose.getPoseImg();

					// "src/main/resources/static/" 부분을 제거
					if (originalPath.contains("src/main/resources/static/")) {
						String relativePath = originalPath.replace("src/main/resources/static/", "/");
						pose.setPoseImg(relativePath); // 상대 경로로 업데이트
						System.out.println(relativePath);
					} else {
						// 만약 교체할 부분이 없으면 경로를 그대로 유지
						System.out.println("경로 변환이 필요하지 않음: " + originalPath);
					}
				}

				model.addAttribute("poses", poses);

			}
		} else {
			model.addAttribute("error", "해당 사용자가 존재하지 않습니다.");
			return "errorPage";
		}

		// Gallery.jsp 페이지로 이동
		return "userGallery";
	}

	@PostMapping("/deleteImage")
	@ResponseBody
	public String deleteImage(@RequestParam("poseIdx") Long poseIdx, HttpSession session) {
		return poseRepository.findById(poseIdx).map(pose -> {
			// 1. 데이터베이스에서 Pose 삭제
			poseRepository.delete(pose);

			// 2. 서버에서 실제 이미지 파일 삭제
			String imagePath = pose.getPoseImg(); // 이미지 경로 얻기

			File imageFile = new File(imagePath);

			if (imageFile.exists()) {
				if (imageFile.delete()) {
					System.out.println("파일이 성공적으로 삭제되었습니다: " + imagePath);
				} else {
					System.out.println("파일 삭제에 실패했습니다: " + imagePath);
				}
			} else {
				System.out.println("파일이 존재하지 않습니다: " + imagePath);
			}

			return "redirect:/Gallery";
		}).orElse("redirect:/Gallery");
	}

}
