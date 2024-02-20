package com.vasy.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vasy.security.dto.UserDetailDto;
import com.vasy.security.service.UserAndAuthoritiesService;

@Controller
@RequestMapping("/public")
public class RoleController {
	
	@Autowired
	private UserAndAuthoritiesService userAndAuthoritiesService;


	
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("IndexPage");
		return modelAndView;
	}
	
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("RegisterPage");
		return modelAndView;
	}
	
	
	@PostMapping("/addUser")
	public String addUser(UserDetailDto userDetailDto) {
		System.out.println(userDetailDto);
		try {
			userAndAuthoritiesService.addUserDetail(userDetailDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/login";
	}
}
