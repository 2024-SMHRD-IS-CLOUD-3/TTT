package com.smhrd.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Target;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_exercise")
public class Exercise {
   //회원이 PT횟수 구매할때 자동생성되는 id
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   // PT구매한 PT회원 아이디
   @ManyToOne
   @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", nullable = false)
   private User user;
	
   // PT구매 한 일자
   @Column(name = "joined_at")
   @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
   private LocalDateTime joinedAt;
   
   // PT 남은 횟수
   @Column(name = "count", length = 3 , nullable = false)
   private int count;
   
   
}
