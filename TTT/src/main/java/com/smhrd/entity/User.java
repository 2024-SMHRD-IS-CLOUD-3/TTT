package com.smhrd.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
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
	@Column(precision = 4, scale = 1)
    private BigDecimal usr_height;

    // 몸무게 
	@Column(precision = 4, scale = 1)
    private BigDecimal usr_weight;

    // 성별
    @Column(length = 1)
    private String usr_gender;

    // 가입일자 
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp joined_at;

    // 프로필 사진 
    @Column(length = 1200, nullable = true)
    private String profile_img;
}