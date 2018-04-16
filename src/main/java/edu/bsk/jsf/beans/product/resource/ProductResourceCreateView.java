package edu.bsk.jsf.beans.product.resource;

import edu.bsk.database.entities.Product;
import edu.bsk.database.entities.ProductResource;
import edu.bsk.database.entities.Resource;
import edu.bsk.database.repositories.ProductRepository;
import edu.bsk.database.repositories.ProductResourceRepository;
import edu.bsk.database.repositories.ResourceRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ProductResourceCreateView
{
	protected ProductResource productResource = new ProductResource();

	protected final ProductResourceRepository productResourceRepository;
	private final ProductRepository productRepository;
	private final ResourceRepository resourceRepository;

	protected Integer productId;
	protected Integer resourceId;

	@Inject
	public ProductResourceCreateView(ProductResourceRepository productResourceRepository,
			ProductRepository productRepository, ResourceRepository resourceRepository)
	{
		this.productResourceRepository = productResourceRepository;
		this.productRepository = productRepository;
		this.resourceRepository = resourceRepository;
	}

	public ProductResource getProductResource()
	{
		return productResource;
	}

	public Integer getProductId()
	{
		return productId;
	}

	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}

	public Integer getResourceId()
	{
		return resourceId;
	}

	public void setResourceId(Integer resourceId)
	{
		this.resourceId = resourceId;
	}

	public void save()
	{
		Product product = productRepository.findById(productId).get();
		Resource resource = resourceRepository.findById(resourceId).get();
		productResource.setProduct(product);
		productResource.setResource(resource);
		productResourceRepository.save(productResource);
	}
}
