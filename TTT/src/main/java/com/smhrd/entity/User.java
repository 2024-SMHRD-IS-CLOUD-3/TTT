package com.smhrd.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class User {
	 // 고유번호 
	@Id
	@Column(length = 40)
    private String usr_id;

    // 이름 
	@Column(length = 50, nullable = false)
    private String usr_name;

    // 전화번호
	@Column(length = 20, nullable = false)
    private String usr_phone;

    // 주소 
	@Column(length = 60, nullable = false)
    private String usr_addr;

    // 키 
    private BigDecimal usr_height;

    // 몸무게 
    private BigDecimal usr_weight;

    // 성별
    @Column(length = 1)
    private String usr_gender;

    // 가입일자 
    private Timestamp joined_at;

    // 프로필 사진 
    @Column(length = 1200, nullable = true)
    private String profile_img;
}