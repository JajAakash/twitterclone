package com.infosys.infytel.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postaction")
public class PostAction {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "postActionId", nullable = false)
	public Integer postActionId;
	
	@Column(name = "subjectId", nullable = false)
	public Integer subjectId;
	
	@Column(name = "posterId", nullable = false)
	private Integer posterId;
	
	@Column(name = "userId", nullable = false)
	private Integer userId;
	
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
	
	
	
	

}
