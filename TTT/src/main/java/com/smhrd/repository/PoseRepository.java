package com.smhrd.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Pose;
import com.smhrd.entity.User;

@Repository
public interface PoseRepository extends JpaRepository<Pose, Long> {
   ArrayList<Pose> findAllByUser(User user);
}