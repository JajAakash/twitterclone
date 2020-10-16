package com.infosys.infytel.customer.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.infosys.infytel.customer.entity.Follower;
import com.infosys.infytel.customer.entity.Post;
import com.infosys.infytel.customer.entity.PostAction;
import com.infosys.infytel.customer.entity.User;
public interface CustomerRepository extends CrudRepository<User, Integer> {
	
	@Query("SELECT email,password,userId FROM User u WHERE u.email = ?1")
	public String findByemail(String email);
	
	@Query("SELECT post FROM Post p WHERE p.userId = ?1")
	List<Object> findByuserId(Integer UserId);
	
	List<User> findByName(String name);

	Post save(Post post);


	public void save(Follower follower);


}
