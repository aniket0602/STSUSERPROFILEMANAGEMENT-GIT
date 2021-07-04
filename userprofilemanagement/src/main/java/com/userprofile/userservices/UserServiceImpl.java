package com.userprofile.userservices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.userprofile.DAO.UserDAO;
import com.userprofile.userentities.User;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
   
	//List<User> list;
	public UserServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new User(1,"User1","Admin"));
//		list.add(new User(2,"User2","Privileged"));
	}
	@Override
	public List<User> getprofiles() {
		// TODO Auto-generated method stub
		//return list;
		return userDAO.findAll();
	}
	@Override
	public User getprofile(long profileId) {
		// TODO Auto-generated method stub
//	  User u=null;
//	  for(User user:list)
//	  {
//		  if(user.getId()==profileId)
//		  {
//			  u=user;
//			  break;
//		  }
//	  }
//	  return u;
		return userDAO.getOne(profileId);
	}
	@Override
	public User addprofile(User user) {
		// TODO Auto-generated method stub
		//list.add(user);
		//return user;
		
    	userDAO.save(user);
    	return user;
	}
	@Override
	public User updateprofile(User user) {
		// TODO Auto-generated method stub
//		list.forEach(e -> {
//			if(e.getId()==user.getId()) {
//				e.setName(user.getName());
//				e.setRole(user.getRole());
//			}
//		});
//		return user;
    	userDAO.save(user);
     	return user;
	}
	@Override
	public void deleteprofile(long profileId) {
		// TODO Auto-generated method stub
    	//list=this.list.stream().filter(e->e.getId()!=profileId).collect(Collectors.toList());
     	User u=userDAO.getOne(profileId);
    	userDAO.delete(u);
	}
   
}
