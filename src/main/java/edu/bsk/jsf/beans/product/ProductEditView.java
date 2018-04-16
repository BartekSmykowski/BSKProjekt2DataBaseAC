package edu.bsk.jsf.beans.product;

import edu.bsk.database.repositories.ProductRepository;
import edu.bsk.database.repositories.ResourceRepository;
import edu.bsk.jsf.beans.resource.ResourcesCreateView;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ProductEditView extends ProductsCreateView
{
	@Inject
	public ProductEditView(ProductRepository productRepository)
	{
		super(productRepository);
	}

	public void initialize(Integer productId)
	{
		this.product = productRepository.findById(productId).get();
	}
}
