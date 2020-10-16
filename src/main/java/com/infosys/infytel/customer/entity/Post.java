package com.infosys.infytel.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "posterId", nullable = false)
	Integer posterId;
	
	@Column(nullable = false, length = 140)
	String post;
	
	@Column(name = "userId", nullable = false)
	Integer userId;
	
//	@Column(name = "followerId", nullable = true)
//	Integer followerId;
	
//	@Column(name = "likerId", nullable = true )
//	Integer likerId;
	


//	public Integer getLikerId() {
//		return likerId;
//	}
//
//	public void setLikerId(Integer likerId) {
//		this.likerId = likerId;
//	}

	public void setPosterId(Integer posterId) {
		this.posterId = posterId;
	}

	public int getPosterId() {
		return posterId;
	}


	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	

}
