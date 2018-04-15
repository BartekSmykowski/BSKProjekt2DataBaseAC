package edu.bsk.jsf.beans.product.resource;

import edu.bsk.database.entities.ProductResource;
import edu.bsk.database.repositories.ProductResourceRepository;
import edu.bsk.database.repositories.ResourceRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ProductResourceMainView
{
	private final ProductResourceRepository productResourceRepository;

	@Inject
	public ProductResourceMainView(ProductResourceRepository productResourceRepository)
	{
		this.productResourceRepository = productResourceRepository;
	}

	public Iterable<ProductResource> getAll()
	{
		return productResourceRepository.findAll();
	}
}
