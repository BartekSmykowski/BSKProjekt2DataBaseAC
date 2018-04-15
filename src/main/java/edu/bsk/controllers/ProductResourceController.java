package edu.bsk.controllers;

import edu.bsk.database.entities.ProductResource;
import edu.bsk.database.repositories.ProductResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product-resource")
public class ProductResourceController
{
	private final ProductResourceRepository productResourceRepository;

	@Autowired
	public ProductResourceController(ProductResourceRepository productResourceRepository)
	{
		this.productResourceRepository = productResourceRepository;
	}

	@RequestMapping({"", "/", "/index"})
	public String index()
	{
		return "product-resource/index";
	}

	@RequestMapping({"/create", "/create/"})
	public String create()
	{
		return "product-resource/create";
	}

	@RequestMapping({"/{id}", "/{id}/"})
	public String show(@PathVariable Integer id, ModelMap model)
	{
		ProductResource productResource = productResourceRepository.findById(id)
				.orElseGet(this::nullProductResource);
		model.addAttribute("productResource", productResource);
		return "product-resource/show";
	}

	private ProductResource nullProductResource()
	{
		ProductResource productResource = new ProductResource();
		productResource.setId(-1);
		productResource.setCount(-1);
		return productResource;
	}
}
