package edu.bsk.jsf.beans.product.resource;

import edu.bsk.database.repositories.ProductRepository;
import edu.bsk.database.repositories.ProductResourceRepository;
import edu.bsk.database.repositories.ResourceRepository;
import edu.bsk.jsf.beans.resource.ResourcesCreateView;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ProductResourceEditView extends ProductResourceCreateView
{
	@Inject
	public ProductResourceEditView(ProductResourceRepository productResourceRepository,
			ProductRepository productRepository, ResourceRepository resourceRepository)
	{
		super(productResourceRepository, productRepository, resourceRepository);
	}

	public void initialize(Integer productResourceId)
	{
		this.productResource = productResourceRepository.findById(productResourceId).get();
		this.productId = productResource.getProduct().getId();
		this.resourceId = productResource.getResource().getId();
	}
}
