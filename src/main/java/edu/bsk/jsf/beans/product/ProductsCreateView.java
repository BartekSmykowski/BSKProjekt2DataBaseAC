package edu.bsk.jsf.beans.product;

import edu.bsk.database.entities.Product;
import edu.bsk.database.repositories.ProductRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ProductsCreateView
{
	protected final ProductRepository productRepository;
	protected Product product = new Product();

	@Inject
	public ProductsCreateView(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}

	public Product getProduct()
	{
		return product;
	}

	public void save()
	{
		productRepository.save(product);
	}
}
