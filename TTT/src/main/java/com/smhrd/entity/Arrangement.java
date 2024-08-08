package com.smhrd.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arrangement {
	
	 // 배치 식별자 
	@Id
	@Column(columnDefinition = "UNSIGNED INT(11)")
    private Long arn_idx;

    // 유저 고유번호 
	@Column(length = 40)
	@ManyToOne
	@JoinColumn(name = "USER_ID")
    private String usr_id;

    // 트레이너 아이디 
	@Column(length = 30)
	@ManyToOne
	@JoinColumn(name = "TRAINER_ID")
    private String tr_id;

    // 배치 날짜 
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp created_at;

    // 배치 상태 
    @Column(length = 20)
    private String arn_status;

    // 프로그램 식별자 
    @Column(columnDefinition = "UNSIGNED INT(11)")
    @ManyToOne
	@JoinColumn(name = "PROGRSM_IDX")
    private Long prg_idx;
}
