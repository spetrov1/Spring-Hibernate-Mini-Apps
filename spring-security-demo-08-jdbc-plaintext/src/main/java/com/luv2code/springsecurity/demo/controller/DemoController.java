package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Component
public class DemoController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/showMyLoginPage")
	public String showLoginForm() {
		return "fancy-login";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
	
	@GetMapping("/leaders")
	public String showLeadersHomePage() {
		return "leaders";
	}

}
