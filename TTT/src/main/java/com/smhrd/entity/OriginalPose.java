package com.smhrd.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OriginalPose {

	// 자세 식별자
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ori_pose_idx;

	// 유저 고유번호
	private String usr_id;

	// 자세 관련내용
	private String ori_pose_memo;

	// 자세 사진1
	private String ori_pose_img1;

	// 자세 사진2
	private String ori_pose_img2;

	// 자세 사진3
	private String ori_pose_img3;

	// 자세 사진4
	private String ori_pose_img4;

	// 자세 사진5
	private String ori_pose_img5;

	// 등록 일자
	private Timestamp created_at;

}
