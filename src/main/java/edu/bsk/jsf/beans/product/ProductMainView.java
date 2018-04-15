package edu.bsk.jsf.beans.product;

import edu.bsk.database.entities.Product;
import edu.bsk.database.entities.ProductionEvent;
import edu.bsk.database.repositories.ProductRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ProductMainView
{
	private final ProductRepository productRepository;

	@Inject
	public ProductMainView(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}

	public Iterable<Product> getAll()
	{
		return productRepository.findAll();
	}
}
