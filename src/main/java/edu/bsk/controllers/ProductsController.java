package edu.bsk.controllers;

import edu.bsk.database.entities.Product;
import edu.bsk.database.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductsController
{
	private final ProductRepository productRepository;

	@Autowired
	public ProductsController(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}

	@RequestMapping({"", "/", "/index"})
	@Secured({"ROLE_admin"})
	public String index()
	{
		return "product/index";
	}

	@RequestMapping({"/create", "/create/"})
	@Secured({"ROLE_admin"})
	public String create()
	{
		return "product/create";
	}

	@RequestMapping({"/{id}", "/{id}/"})
	@Secured({"ROLE_admin"})
	public String show(@PathVariable Integer id, ModelMap model)
	{
		Product product = productRepository.findById(id)
				.orElseGet(this::nullProduct);
		model.addAttribute("product", product);
		return "product/show";
	}

	private Product nullProduct()
	{
		Product product = new Product();
		product.setName("Not found");
		return product;
	}
}
