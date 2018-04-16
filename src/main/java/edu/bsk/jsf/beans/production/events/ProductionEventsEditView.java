package edu.bsk.jsf.beans.production.events;

import edu.bsk.database.repositories.EmployeeRepository;
import edu.bsk.database.repositories.ProductRepository;
import edu.bsk.database.repositories.ProductionEventRepository;
import edu.bsk.database.repositories.ResourceRepository;
import edu.bsk.jsf.beans.resource.ResourcesCreateView;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ProductionEventsEditView extends ProductionEventsCreateView
{
	@Inject
	public ProductionEventsEditView(ProductionEventRepository productionEventRepository,
			EmployeeRepository employeeRepository, ProductRepository productRepository)
	{
		super(productionEventRepository, employeeRepository, productRepository);
	}

	public void initialize(Integer productionEventId)
	{
		this.productionEvent = productionEventRepository.findById(productionEventId).get();
		this.productId = productionEvent.getProduct().getId();
		this.employeeId = productionEvent.getEmployee().getPESEL();
	}
}
