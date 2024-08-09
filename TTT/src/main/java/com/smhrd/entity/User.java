package com.smhrd.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.type.TimestampType;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long urId;

    // 이름 
	@Column(length = 50)
    private String urName;
	
	

    // 전화번호
	@Column(length = 20)
    private String urPhone;

    // 주소 
	@Column(length = 60)
    private String urAddress;

    // 키
	@Column(precision = 4, scale = 1, nullable = true)
    private BigDecimal urHeight;

    // 몸무게 
	@Column(precision = 4, scale = 1, nullable = true)
    private BigDecimal urWeight;

    // 성별
    @Column(length = 1, nullable = true)
    private String urGender;

    // 가입일자 
    @Basic(optional=false)
    @Column(columnDefinition = "TIMESTAMP", insertable = false, updatable = false)
    @CreationTimestamp
    private String joinedAt;

    // 프로필 사진 
    @Column(length = 1200, nullable = true)
    private String profileImg;
}