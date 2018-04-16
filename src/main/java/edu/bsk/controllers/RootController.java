package edu.bsk.controllers;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController
{
	@GetMapping("/")
	public String welcomePage(SecurityContextHolderAwareRequestWrapper securityContext)
	{
		if(!isUserLoggedIn(securityContext))
			return "redirect:/authentication/login";
		return "index";
	}

	private boolean isUserLoggedIn(SecurityContextHolderAwareRequestWrapper securityContext)
	{
		return securityContext.getRemoteUser() != null;
	}

} 
 