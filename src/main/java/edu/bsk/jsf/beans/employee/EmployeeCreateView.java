package edu.bsk.jsf.beans.employee;

import edu.bsk.database.entities.Employee;
import edu.bsk.database.entities.Product;
import edu.bsk.database.repositories.EmployeeRepository;
import edu.bsk.database.repositories.ProductRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class EmployeeCreateView
{
	private final EmployeeRepository employeeRepository;

	private final Employee employee = new Employee();

	@Inject
	public EmployeeCreateView(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void save()
	{
		employeeRepository.save(employee);
	}
}
