package com.userprofile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userprofile.userentities.User;
import com.userprofile.userservices.UserService;
@RestController
public class usercontroller {
	
	@Autowired
	private UserService userservice;
	//Welcome page
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to User profile management";
	}
	//Get the user profiles
	@GetMapping("/profiles")
	public List<User> getprofiles()
	{
		return this.userservice.getprofiles();
	}
	
	@GetMapping("/profiles/{profileId}")
	public User getprofile(@PathVariable String profileId)
	{
		return this.userservice.getprofile(Long.parseLong(profileId));
	}
	@PostMapping("/profiles")
	public User addprofile(@RequestBody User user)
	{
		return this.userservice.addprofile(user);
	}
	@PutMapping("/profiles")
	public User updateprofile(@RequestBody User user) {
		return this.userservice.updateprofile(user);
	}
	@DeleteMapping("/profiles/{profileId}")
	public ResponseEntity<HttpStatus> deleteprofile(@PathVariable String profileId){
		try {
			this.userservice.deleteprofile(Long.parseLong(profileId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		}
	
}
