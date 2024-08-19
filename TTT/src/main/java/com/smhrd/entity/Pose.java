package com.smhrd.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tb_pose")
public class Pose {

   // 자세 식별자
   @Id
   @Column(name = "pose_idx", length = 40)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long poseIdx;

   // 유저 고유번호
   @ManyToOne
   @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", nullable = false)
   private User user;

   // 자세 사진
   @Column(name = "pose_img", length = 1200)
   private String poseImg;

   // front or side 자세
   @Column(name = "pose_type", length = 10)
   private String poseType;
   
   // 등록 일자
   @Column(name = "created_at")
   @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
   private Timestamp createdAt;
   
   // 파일 저장 확장자
   @Column(name = "file_ext", length = 10)
   private String fileExt;


   

}
