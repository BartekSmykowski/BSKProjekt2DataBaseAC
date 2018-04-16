package edu.bsk.jsf.beans.production.events;

import edu.bsk.database.entities.Employee;
import edu.bsk.database.entities.Product;
import edu.bsk.database.entities.ProductionEvent;
import edu.bsk.database.repositories.EmployeeRepository;
import edu.bsk.database.repositories.ProductRepository;
import edu.bsk.database.repositories.ProductionEventRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ProductionEventsCreateView
{
	protected final ProductionEventRepository productionEventRepository;
	private final EmployeeRepository employeeRepository;
	private final ProductRepository productRepository;

	protected ProductionEvent productionEvent = new ProductionEvent();
	protected int productId;
	protected String employeeId;

	@Inject
	public ProductionEventsCreateView(ProductionEventRepository productionEventRepository,
			EmployeeRepository employeeRepository, ProductRepository productRepository)
	{
		this.productionEventRepository = productionEventRepository;
		this.employeeRepository = employeeRepository;
		this.productRepository = productRepository;
	}

	public ProductionEvent getProductionEvent()
	{
		return productionEvent;
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public String getEmployeeId()
	{
		return employeeId;
	}

	public void setEmployeeId(String employeeId)
	{
		this.employeeId = employeeId;
	}

	public void save()
	{
		Product product = productRepository.findById(productId).get();
		Employee employee = employeeRepository.findById(employeeId).get();
		productionEvent.setProduct(product);
		productionEvent.setEmployee(employee);
		productionEventRepository.save(productionEvent);
	}
}
