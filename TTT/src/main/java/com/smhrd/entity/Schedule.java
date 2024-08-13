package com.smhrd.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_schedule")
public class Schedule {
	
	@Id
	@Column(name="sche_idx")
	private Long id;
	
	@JoinColumn(name = "tr_id")
	@ManyToOne(targetEntity = Trainer.class)
	private String trainerId;
	
	@Column(name="sche_content")
	private String description;
	
	@Column(name="sche_")
	private LocalDate startDate;
	
	@Column(name="st_tm")
	private LocalDateTime startTime;
	
	@Column(name="ed_dt")
	private LocalDate endDate;
	
	@Column(name="ed_tm")
	private LocalDateTime endTime;
	
	@Column(name="sche_color")	
	private String color;
	
	@Column(name="sche_status")
	private String status;
	
	@JoinColumn(name = "usr_id")
	@ManyToOne(targetEntity = User.class)
	private Long userId;
	
}
