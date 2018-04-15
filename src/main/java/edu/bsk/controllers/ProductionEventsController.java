package edu.bsk.controllers;

import edu.bsk.database.entities.Product;
import edu.bsk.database.entities.ProductionEvent;
import edu.bsk.database.repositories.ProductionEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/production-event")
public class ProductionEventsController
{
	private final ProductionEventRepository productionEventRepository;

	@Autowired
	public ProductionEventsController(ProductionEventRepository productionEventRepository)
	{
		this.productionEventRepository = productionEventRepository;
	}

	@RequestMapping({"", "/", "/index"})
	@Secured({"ROLE_admin", "ROLE_brygadzista"})
	public String index()
	{
		return "production-event/index";
	}

	@RequestMapping({"/create", "/create/"})
	@Secured({"ROLE_admin", "ROLE_brygadzista"})
	public String create()
	{
		return "production-event/create";
	}

	@RequestMapping({"/{id}", "/{id}/"})
	@Secured({"ROLE_admin", "ROLE_brygadzista"})
	public String show(@PathVariable Integer id, ModelMap model)
	{
		ProductionEvent productionEvent = productionEventRepository.findById(id)
				.orElseGet(this::nullProductionEvent);
		model.addAttribute("productionEvent", productionEvent);
		return "production-event/show";
	}

	private ProductionEvent nullProductionEvent()
	{
		ProductionEvent productionEvent = new ProductionEvent();
		productionEvent.setCount(-1);
		productionEvent.setId(-1);
		productionEvent.setProductionLine(-1);
		productionEvent.setWorkplace(-1);
		return productionEvent;
	}
}
