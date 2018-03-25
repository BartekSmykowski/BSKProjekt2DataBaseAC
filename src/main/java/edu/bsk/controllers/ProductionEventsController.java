package edu.bsk.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/production-event")
public class ProductionEventsController
{
	@RequestMapping({"", "/", "/index"})
	@PreAuthorize("hasAnyRole('ROLE_admin', 'ROLE_brygadzista')")
	public String index()
	{
		return "production-event/index";
	}

	@RequestMapping({"/create", "/create/"})
	@Secured({"admin", "brygadzista"})
	public String create()
	{
		return "production-event/create";
	}
}
