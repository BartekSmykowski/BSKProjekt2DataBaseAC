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
	@Secured({"ROLE_admin", "ROLE_sprzedawca", "ROLE_magazynier", "ROLE_projektant_produktow"})
	public String index()
	{
		return "product/index";
	}

	@RequestMapping({"/create", "/create/", "ROLE_projektant_produktow"})
	@Secured({"ROLE_admin", "ROLE_magazynier"})
	public String create()
	{
		return "product/create";
	}

	@RequestMapping({"/{id}", "/{id}/"})
	@Secured({"ROLE_admin", "ROLE_sprzedawca", "ROLE_magazynier", "ROLE_projektant_produktow"})
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

	@RequestMapping({"/{id}/edit", "/{id}/edit/"})
	@Secured({"ROLE_admin", "ROLE_magazynier", "ROLE_projektant_produktow"})
	public String edit(@PathVariable Integer id, ModelMap model)
	{
		model.addAttribute("productId", id);
		return "product/edit";
	}

	@RequestMapping({"/{id}/delete", "/{id}/delete/"})
	@Secured({"ROLE_admin", "ROLE_magazynier", "ROLE_projektant_produktow"})
	public String delete(@PathVariable Integer id)
	{
		productRepository.deleteById(id);
		return "redirect:/product/";
	}
}
