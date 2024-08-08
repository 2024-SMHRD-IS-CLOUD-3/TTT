package com.smhrd.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_trainer")
public class Trainer {

	// 아이디
	@Id
	@Column(name = "tr_id", length = 30)
	private String id;

	// 비밀번호
	@Column(name = "tr_pw", length = 32, nullable = false)
	private String pw;

	// 이름
	@Column(name = "tr_name", length = 50, nullable = false)
	private String name;

	// 생년월일
	@Column(name = "tr_birthdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate  birthdate;

	// 전화번호
	@Column(name = "tr_phone", length = 20, nullable = false)
	private String phone;

	// 이메일
	@Column(name = "tr_email", length = 50, nullable = false)
	private String email;

	// 가입일자
	@Column(name = "joined_at")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime joinedAt;

	// 유형
	@Column(name = "tr_type", length = 10, nullable = false)
	private String type;

	// 센터 식별자
//	@JoinColumn(name = "idx")
//	@ManyToOne(targetEntity = FitnessCenter.class)
//	private Long fcIdx;

	// 프로필 사진
	@Column(name = "profile_img", length = 1200, nullable = true)
	private String profileImg;

	// 토큰값
	@Column(name = "tr_token", length = 195, nullable = false)
	private String token;

}