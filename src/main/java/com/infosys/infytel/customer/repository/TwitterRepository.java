package com.infosys.infytel.customer.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.infytel.customer.entity.PostAction;


@Repository
public class TwitterRepository {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void insertWithQuery(PostAction post) {
	    entityManager.createNativeQuery("INSERT INTO postaction (poster_id,subject_id,userid) VALUES (?,?)")
	      .setParameter(1, post.getPosterId())
	      .setParameter(2, post.getSubjectId())
	      .setParameter(3, post.getUserId())
	      .executeUpdate();
	}
	
	public List myAllPosts(Integer uId) {
		
	    javax.persistence.Query q = entityManager.createNativeQuery("select distinct post from(select p.post,p.poster_id from Post p inner  join Follower f on f.user_id = p.user_id where f.follower_id= ?1 UNION ALL select p.post,p.poster_id from Post p inner  join postaction pa on pa.poster_id = p.poster_id where pa.subject_id= ?1) as postdetails");
	    q.setParameter(1, uId);
	    
	    return  q.getResultList();
		 
	}

}
