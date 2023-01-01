package org.gen.springboot.controller;

import org.gen.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/deleteUserById")
	public void deleteUserById(Integer id) {
		userService.deleteUserById(id);
	}

	@RequestMapping("/getUser/{id}")
	public String getUserById(@PathVariable int id) {
		return userService.getUserById(id).toString();
	}
}
