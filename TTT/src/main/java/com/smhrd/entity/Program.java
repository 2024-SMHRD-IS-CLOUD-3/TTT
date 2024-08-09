//package com.smhrd.entity;
//
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Program {
//	// 프로그램 식별자 
//	@Id
//	@Column(columnDefinition = "UNSIGNED INT(11)")
//    private Long prg_idx;
//
//    // 프로그램 이름 
//    private String prg_name;
//
//    // 횟수 
//    private Integer prg_count;
//
//    // 프로그램 가격 
//    @Column(columnDefinition = "INTEGER")
//    private Integer prg_price;
//
//    // 센터 식별자 
//    @Column(columnDefinition = "UNSIGNED INT(11)")
//    @ManyToOne
//	@JoinColumn(name = "FC_IDX")
//    private Long fc_idx;
//
//}
