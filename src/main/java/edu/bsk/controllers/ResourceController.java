package edu.bsk.controllers;

import edu.bsk.database.entities.Product;
import edu.bsk.database.entities.Resource;
import edu.bsk.database.repositories.ProductRepository;
import edu.bsk.database.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resource")
public class ResourceController
{
	private final ResourceRepository resourceRepository;

	@Autowired
	public ResourceController(ResourceRepository resourceRepository)
	{
		this.resourceRepository = resourceRepository;
	}

	@RequestMapping({"", "/", "/index"})
	@Secured({"ROLE_admin", "ROLE_magazynier", "ROLE_projektant_produktow"})
	public String index()
	{
		return "resource/index";
	}

	@RequestMapping({"/create", "/create/"})
	@Secured({"ROLE_admin", "ROLE_magazynier", "ROLE_projektant_produktow"})
	public String create()
	{
		return "resource/create";
	}

	@RequestMapping({"/{id}", "/{id}/"})
	@Secured({"ROLE_admin", "ROLE_magazynier", "ROLE_projektant_produktow"})
	public String show(@PathVariable Integer id, ModelMap model)
	{
		Resource resource = resourceRepository.findById(id)
				.orElseGet(this::nullResource);
		model.addAttribute("_resource", resource);
		return "resource/show";
	}

	private Resource nullResource()
	{
		Resource resource = new Resource();
		resource.setName("Not found");
		return resource;
	}
}
