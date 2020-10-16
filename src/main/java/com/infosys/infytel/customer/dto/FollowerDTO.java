package com.infosys.infytel.customer.dto;

import com.infosys.infytel.customer.entity.Follower;
import com.infosys.infytel.customer.entity.Post;

public class FollowerDTO {
	
	private Integer followId ;

	private Integer userId;
	
	private Integer followerId;
	
	public Integer getFollowId() {
		return followId;
	}

	public void setFollowId(Integer followId) {
		this.followId = followId;
	}




	public Integer getUserId() {
		return userId;
	}




	public void setUserId(Integer userId) {
		this.userId = userId;
	}




	public Integer getFollowerId() {
		return followerId;
	}




	public void setFollowerId(Integer followerId) {
		this.followerId = followerId;
	}



	// DTO to Entity conversion
	
	public Follower saveFollowerEntity() {
		Follower follower = new Follower();
		follower.setUserId(this.userId);
		follower.setFollowerId(this.followerId);
		return follower;
	}
}
