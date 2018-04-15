package edu.bsk.jsf.beans.employee;

import edu.bsk.database.entities.Employee;
import edu.bsk.database.repositories.EmployeeRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class EmployeeMainView
{
	private final EmployeeRepository employeeRepository;

	@Inject
	public EmployeeMainView(EmployeeRepository productRepository)
	{
		this.employeeRepository = productRepository;
	}

	public Iterable<Employee> getAll()
	{
		return employeeRepository.findAll();
	}
}
