package com.smhrd.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class User {

    // 고유번호 (Primary Key)
    @Id
    @Column(name = "usr_id", length = 40)
    private String urId;

    // 이름 
    @Column(name = "usr_name", length = 50)
    private String urName;

    // 전화번호
    @Column(name = "usr_phone", length = 20)
    private String urPhone;

    // 주소 
    @Column(name = "usr_address", length = 60)
    private String urAddress;

    // 키
    @Column(name = "usr_height", precision = 4, scale = 1, nullable = true)
    private BigDecimal urHeight;

    // 몸무게 
    @Column(name = "usr_weight", precision = 4, scale = 1, nullable = true)
    private BigDecimal urWeight;

    // 성별
    @Column(name = "usr_gender", length = 1, nullable = true)
    private String urGender;

    // 가입일자 
    @Column(name = "joined_at", columnDefinition = "TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime joinedAt;

    // 프로필 사진 
    @Column(name = "profile_img", length = 1200, nullable = true)
    private String profileImg;
}
