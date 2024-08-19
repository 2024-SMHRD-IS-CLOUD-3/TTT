package com.smhrd.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_memo")
public class Memo {

    @Id
    @Column(name = "memo_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memoIdx;

    @ManyToOne
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", nullable = false)
    private User user;

    @Column(name = "memo_content", length = 1000)
    private String memoContent;
    
    @Column(name = "created_at")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdAt;
}
