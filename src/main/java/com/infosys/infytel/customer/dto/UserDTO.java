package com.infosys.infytel.customer.dto;

import java.util.List;

import com.infosys.infytel.customer.entity.Post;
import com.infosys.infytel.customer.entity.User;


public class UserDTO {

	private long mobile;
	private String name;
	private String email;
	private String password;
	private int userId;
//	private List<Post> post;
//	
//	public List<Post> getPost() {
//		return post;
//	}
//	public void setPost(List<Post> post) {
//		this.post = post;
//	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	// Converts DTO into Entity
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public User createUserEntity() {
		User user = new User();
		user.setEmail(this.email);
		user.setPassword(this.password);
		user.setName(this.name);
		user.setMobile(this.mobile);
		user.setUserId(this.userId);
		//user.setPost(this.post);
		return user;
	}
			


//	@Override
//	public String toString() {
//		return "CustomerDTO [phoneNo=" + phoneNo + ", name=" + name + ", age=" + age + ", gender=" + gender
//				+ ", friendAndFamily=" + friendAndFamily + ", password=" + password + ", address=" + address
//				+ ", currentPlan=" + currentPlan + "]";
//	}

//		// Converts Entity into DTO
		public static UserDTO valueOf(User user) {
			UserDTO userDTO = new UserDTO();
			userDTO.setEmail(user.getEmail());
			userDTO.setMobile(user.getMobile());
			userDTO.setName(user.getName());
			return userDTO;
		}

		// Converts DTO into Entity
		public User createEntity() {
			User user = new User();
			user.setEmail(this.getEmail());
			user.setMobile(this.getMobile());
			user.setName(this.getName());
			user.setPassword(this.getPassword());
			//user.setUserId(userId);
			
			return user;
		}


}
