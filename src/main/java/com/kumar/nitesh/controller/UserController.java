package com.kumar.nitesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kumar.nitesh.repository.AuthorityRepository;
import com.kumar.nitesh.repository.UserRepository;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserRepository users;

	@Autowired
	AuthorityRepository authorities;

	// GET /login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String log(Model model) {
		return "index";
	}
}
