package com.infosys.infytel.customer.dto;

import com.infosys.infytel.customer.entity.Post;

public class PostDTO {

	Integer posterId;
	
	String post;

	Integer userId;
	
	//Integer followerId;
	
	//private Integer likerId;
	
	
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	


	

	
//	public PlanDTO() {
//		super();
//	}


//	@Override
//	public String toString() {
//		return "PlanDTO [planId=" + planId + ", planName=" + planName + ", nationalRate=" + nationalRate
//				+ ", localRate=" + localRate + "]";
//	}
	
	

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public String getPost() {
		return post;
	}

	public Integer getPosterId() {
		return posterId;
	}

	public void setPosterId(Integer posterId) {
		this.posterId = posterId;
	}

	public void setPost(String post) {
		this.post = post;
	}

//	public Integer getFollowerId() {
//		return followerId;
//	}
//
//	public void setFollowerId(Integer followerId) {
//		this.followerId = followerId;
//	}



	public Post createPostEntity() {
		Post post = new Post();
		post.setPost(this.post);
		post.setUserId(this.userId);
		//post.setFollowerId(this.followerId);
		//post.setLikerId(this.likerId);
		return post;
	}
	
	public Post likePostEntity() {
		Post post = new Post();
		post.setPosterId(this.posterId);
		//post.setFollowerId(this.followerId);
		//post.setLikerId(this.likerId);
		return post;
	}
	
	// Converts Entity into DTO
			public static PostDTO valueOf(Post post) {
				PostDTO postDTO = new PostDTO();
				postDTO.setPost(post.getPost());
				postDTO.setUserId(post.getUserId());
				//postDTO.setFollowerId(post.getFollowerId());
				//post.setLikerId(post.getLikerId());
//				custDTO.setGender(cust.getGender());
//				custDTO.setName(cust.getName());
//				custDTO.setPhoneNo(cust.getPhoneNo());
//				custDTO.setAddress(cust.getAddress());
//				PlanDTO planDTO = new PlanDTO();
//				planDTO.setPlanId(cust.getPlanId());
//				custDTO.setCurrentPlan(planDTO);
//				custDTO.setCurrentPlan(planDTO);
				
				
				
				return postDTO;
			}



}
