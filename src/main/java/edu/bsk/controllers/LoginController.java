package edu.bsk.controllers;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authentication/login")
public class LoginController
{
	@GetMapping
	public String welcomePage(SecurityContextHolderAwareRequestWrapper securityContext)
	{
		if (isUserLoggedIn(securityContext))
			return "redirect:/";
		return "authentication/login";
	}

	private boolean isUserLoggedIn(SecurityContextHolderAwareRequestWrapper securityContext)
	{
		return securityContext.getRemoteUser() != null;
	}
}
