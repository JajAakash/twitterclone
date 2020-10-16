package com.infosys.infytel.customer.dto;

import com.infosys.infytel.customer.entity.PostAction;

public class PostActionDTO {
	public Integer postActionId;
	public Integer subjectId;
	public Integer userId;
	private Integer posterId;
	public Integer getPostActionId() {
		return postActionId;
	}
	public void setPostActionId(Integer postActionId) {
		this.postActionId = postActionId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public Integer getPosterId() {
		return posterId;
	}
	public void setPosterId(Integer posterId) {
		this.posterId = posterId;
	}
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	// create DTO TO ENTITY
	public PostAction postActionEntity () {
		
		PostAction postAction = new PostAction();
		postAction.setPosterId(this.posterId);
		postAction.setSubjectId(this.subjectId);
		postAction.setSubjectId(this.userId);
		return postAction;
		
	}
	

}
