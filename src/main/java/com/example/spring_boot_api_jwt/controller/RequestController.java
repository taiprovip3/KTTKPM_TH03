package com.example.spring_boot_api_jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_boot_api_jwt.entity.User;

@Controller
public class RequestController {
	
	@RequestMapping("/")
	public String showMyHomePage() {
		return "user/index";
	}
	
	@GetMapping("/admin")
	public String showMyAdminPage() {
		return "admin/index";
	}
	
	@GetMapping("/AccessDenied")
	public String showAcessDeniedPage() {
		return "access-denied";
	}
}
