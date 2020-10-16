package com.infosys.infytel.customer.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.infytel.customer.dto.FollowerDTO;
import com.infosys.infytel.customer.dto.LoginDTO;
import com.infosys.infytel.customer.dto.PostActionDTO;
import com.infosys.infytel.customer.dto.PostDTO;
import com.infosys.infytel.customer.dto.UserDTO;
import com.infosys.infytel.customer.entity.Follower;
import com.infosys.infytel.customer.entity.Post;
import com.infosys.infytel.customer.entity.PostAction;
import com.infosys.infytel.customer.entity.User;
import com.infosys.infytel.customer.repository.CustomerRepository;

import com.infosys.infytel.customer.repository.TwitterRepository;
import com.infosys.infytel.exception.LimitIncreasedException;
import com.infosys.infytel.exception.UserNotFoundException;
import com.infosys.infytel.exception.WrongCredentialException;

@Service
@Transactional(readOnly = false)
public class CustomerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CustomerRepository userRepo;
	
	@Autowired
	TwitterRepository repository;
	
	
	// service for creating user
	public User createUser(UserDTO userDTO)  {
		logger.info("Creation request for user {}", userDTO);
		User user = userDTO.createEntity();
		return userRepo.save(user);
	}
	
	//service for creating post
	public Post createPost(PostDTO postDTO) throws Exception {
		logger.info("Creation request for post {}", postDTO);			
		Post post = postDTO.createPostEntity();
		if(post.getPost().split(" ").length>140) {
			throw new LimitIncreasedException();  
		};
		return userRepo.save(post);
	}
	
	//Service for follow a user
	public void saveFollower(FollowerDTO FollowerDTO) {
		logger.info("Creation request for follower for userId ", FollowerDTO);
		Follower follower  = FollowerDTO.saveFollowerEntity();
		userRepo.save(follower);
		
	}
	
	// Like a post
	public void storeLike(PostActionDTO postActionDTO) {
		logger.info("Creation request for likes ", postActionDTO);
		PostAction post = postActionDTO.postActionEntity();
		
		
		repository.insertWithQuery(post);
		
		
	}
	
	
	
	// Login with user feed
	public List<Object> login(LoginDTO loginDTO) throws WrongCredentialException {
		logger.info("Login request for customer {} with password {}",loginDTO.getPassword() );
		String userDetails = userRepo.findByemail(loginDTO.getEmail());
		logger.info("Login request for customer {} with password {}",userDetails );
		if (userDetails != null && userDetails.split(",")[1].equals(loginDTO.getPassword())) {
			return repository.myAllPosts(Integer.parseInt(userDetails.split(",")[2]));
		}
		else {
			throw new WrongCredentialException();
		}
	}

	// Service for fetching full profile of a specific user by name	
	public ArrayList<UserDTO> getuserProfile( String name) throws UserNotFoundException {
		logger.info("Profile request for user {}", name);
		//User user = userRepo.findById(userId).get();		
		//UserDTO userDTO = UserDTO.valueOf(user);
		ArrayList<UserDTO> userArray= new ArrayList<>();
		User user = new User();
		List<User> userList = userRepo.findByName(name);
		if(userList.isEmpty()) {
			throw new UserNotFoundException();
		}
		else {
			for(User u : userList) {
				user.setEmail(u.getEmail());
				user.setMobile(u.getMobile());
				user.setName(u.getName());
				
				
				userArray.add(UserDTO.valueOf(user));
			}
			 return userArray;
		}
		
		 
	}
	
	public List<Object> getallPost(Integer userId){
		
		logger.info("Profile request for user {}", userId);
		ArrayList<PostDTO> postArray= new ArrayList<>();
		Post post = new Post();
		List<Object> postList = userRepo.findByuserId(userId);
		return postList;
		
	}


}
