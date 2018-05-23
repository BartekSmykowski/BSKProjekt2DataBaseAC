package edu.bsk.controllers;

import edu.bsk.database.repositories.UserRepository;
import edu.bsk.jsf.beans.RolesData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authentication/login")
public class LoginController
{
	private UserRepository userRepository;

	@Autowired
	public LoginController(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@GetMapping
	public String welcomePage(Authentication authentication, ModelMap model)
	{
		if (isUserLoggedIn(authentication))
			return "redirect:/";
		model.addAttribute("loginData", new RolesData());
		return "authentication/login";
	}

	private boolean isUserLoggedIn(Authentication authentication)
	{
		if(authentication == null)
			return false;
		return authentication.isAuthenticated();
	}

}
