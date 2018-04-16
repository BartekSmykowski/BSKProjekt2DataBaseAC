package edu.bsk.jsf.beans.employee;

import edu.bsk.database.repositories.EmployeeRepository;
import edu.bsk.database.repositories.ResourceRepository;
import edu.bsk.jsf.beans.resource.ResourcesCreateView;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class EmployeeEditView extends EmployeeCreateView
{
	@Inject
	public EmployeeEditView(EmployeeRepository employeeRepository)
	{
		super(employeeRepository);
	}

	public void initialize(String employeePESEL)
	{
		this.employee = employeeRepository.findById(employeePESEL).get();
	}
}
