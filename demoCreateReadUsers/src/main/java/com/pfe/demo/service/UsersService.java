package com.pfe.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.demo.model.User;
import com.pfe.demo.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository userRepository;

	public List<User> getUsers()
	{
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(u -> users.add(u));
		return users;
	}
	
	public void addOrUpdateUser(User user) 
	{
		userRepository.save(user);
	}
	
	public void deleteUser(int _id)
	{
		userRepository.deleteById(_id);
	}
	
	
}
