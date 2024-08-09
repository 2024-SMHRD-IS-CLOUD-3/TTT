package com.smhrd.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {

	// 아이디
	@Id
	@Column(length = 30)
	private String id;

	// 비밀번호
	@Column(length = 32, nullable = false)
	private String pw;

	// 이름
	@Column(length = 50, nullable = false)
	private String trName;

	// 생년월일
	private Timestamp trBirthdate;

	// 전화번호
	@Column(length = 20, nullable = false)
	private String trPhone;

	// 이메일
	@Column(length = 50, nullable = false)
	private String trEmail;

	// 가입일자
	private Timestamp joinedAt;

	// 유형
	@Column(length = 10, nullable = false)
	private String trType;

	// 센터 식별자
	private Long fcIdx;

	// 프로필 사진
	@Column(length = 1200, nullable = true)
	private String profileImg;

	// 토큰값
	@Column(length = 195, nullable = false)
	private String trToken;

}