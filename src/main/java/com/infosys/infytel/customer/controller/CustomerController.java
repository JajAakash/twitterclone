package com.infosys.infytel.customer.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infytel.customer.dto.FollowerDTO;
import com.infosys.infytel.customer.dto.LoginDTO;
import com.infosys.infytel.customer.dto.PostActionDTO;
import com.infosys.infytel.customer.dto.PostDTO;
import com.infosys.infytel.customer.dto.UserDTO;
import com.infosys.infytel.customer.entity.Post;
import com.infosys.infytel.customer.entity.User;
import com.infosys.infytel.customer.service.CustomerService;
import com.infosys.infytel.exception.UserNotFoundException;
import com.infosys.infytel.exception.WrongCredentialException;

@RestController
@CrossOrigin
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService userService;
	
	// Create a new customer
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User createCustomer(@RequestBody UserDTO userDTO) {
		logger.info("Creation request for user {}", userDTO);
		return userService.createUser(userDTO);
	}
	
	// Create a new post
	@RequestMapping(value = "/post", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Post createPost(@RequestBody PostDTO postDTO ) throws Exception {
		logger.info("Creation request for post {}", postDTO);
		return userService.createPost(postDTO);
	}
		
	// Create a follower
	@RequestMapping(value = "/follow", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addFollower(@RequestBody FollowerDTO followDTO ) {
		logger.info("Creation request for follower for user", followDTO);
		userService.saveFollower(followDTO);
	}
	// store a like
		@RequestMapping(value = "/like", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public void saveLikes(@RequestBody PostActionDTO postActionDTO ) {
			logger.info("Creation request for store like for user", postActionDTO);
			userService.storeLike(postActionDTO);
		}
	// Login
	@RequestMapping(value = "/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> login(@RequestBody LoginDTO loginDTO) throws WrongCredentialException {
		logger.info("Login request for user {} with email {}", loginDTO.getEmail());
		return userService.login(loginDTO);
	}
	
	// Fetches full profile of a specific user by name
	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<UserDTO> getCustomerProfile(@PathVariable String name) throws UserNotFoundException {
		logger.info("Profile request for user {}", name);
		ArrayList<UserDTO> userDTO=userService.getuserProfile(name);
		return userDTO;
	}
	
	//All post for an user
	@RequestMapping(value = "/post/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> getallPost(@PathVariable Integer userId) {
		
		logger.info("all post request for user {}", userId);
		
		List<Object> postDTO=userService.getallPost(userId);
		
		return postDTO;
	}



}
