package com.pfe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.pfe.demo.model.User;
import com.pfe.demo.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/")
	public String viewIndexPage()
	{
		return "index";
	}
	@RequestMapping(value = "users" ,method = RequestMethod.GET)
	public String viewIndexPage(Model model)
	{
		List<User> userlist = usersService.getUsers();
		model.addAttribute("users", userlist);
		
		return "users";
	}
	@RequestMapping(value = "create_user" ,method = RequestMethod.POST)
	public String createNewUser(@ModelAttribute("user") User user)
	{
		usersService.addOrUpdateUser(user);
		
		return "redirect:/";
	}
	
}
