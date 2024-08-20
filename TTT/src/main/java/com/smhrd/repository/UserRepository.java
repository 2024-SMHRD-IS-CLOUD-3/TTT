package com.smhrd.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Trainer;
import com.smhrd.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
   
	@Query(value = "select t.tr_id, u.usr_id, u.usr_name, u.usr_gender, u.usr_birthdate, e.count " +
            "from tb_trainer t " +
            "join tb_user u on t.tr_id = u.tr_id "+
            "left join " +
            "(select exer.usr_id, exer.count, exer.joined_at from tb_exercise exer " +
            "inner join (select usr_id, max(joined_at) as max_date from tb_exercise " +
            "group by usr_id) " +
            "latest_exer " +
            "on exer.usr_id = latest_exer.usr_id " +
            "and exer.joined_at = latest_exer.max_date " +
            ") e " +
            "on u.usr_id = e.usr_id " +
            "order by u.usr_id",
    nativeQuery = true)
   ArrayList<UserWithLatestCountDTO> findAllUsersWithLatestCount();
   
	public List<User> findByTrainer(Trainer trainer);

}
