package edu.bsk.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController
{
	@GetMapping("/")
	public String welcomePage(Authentication authentication)
	{
		if(!isUserLoggedIn(authentication))
			return "redirect:/authentication/login";
		return "index";
	}

	private boolean isUserLoggedIn(Authentication authentication)
	{
		if(authentication == null)
			return false;
		return authentication.isAuthenticated();
	}

} 
 