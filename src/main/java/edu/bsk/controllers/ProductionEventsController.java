package edu.bsk.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/production-event")
public class ProductionEventsController
{
	@RequestMapping({"", "/", "/index"})
	@Secured({"brygadzista"})
	public String index()
	{
		return "production-event/index";
	}
}
