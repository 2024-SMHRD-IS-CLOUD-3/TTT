package com.smhrd.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Memo;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
   ArrayList<Memo> findAllByMemoIdx(Long memoId);
   List<Memo> findAllByUserId(String userId);

}
