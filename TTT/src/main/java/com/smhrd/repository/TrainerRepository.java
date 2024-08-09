package com.smhrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
	public Trainer findByIdAndPw(String id, String pw);
}
