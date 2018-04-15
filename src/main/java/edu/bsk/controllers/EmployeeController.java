package edu.bsk.controllers;

import edu.bsk.database.entities.Employee;
import edu.bsk.database.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController
{
	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeController(EmployeeRepository productRepository)
	{
		this.employeeRepository = productRepository;
	}

	@RequestMapping({"", "/", "/index"})
	@Secured({"ROLE_admin"})
	public String index()
	{
		return "employee/index";
	}

	@RequestMapping({"/create", "/create/"})
	@Secured({"ROLE_admin"})
	public String create()
	{
		return "employee/create";
	}

	@RequestMapping({"/{PESEL}", "/{PESEL}/"})
	@Secured({"ROLE_magazynier"})
	public String show(@PathVariable String PESEL, ModelMap model)
	{
		Employee product = employeeRepository.findById(PESEL)
				.orElseGet(this::nullEmployee);
		model.addAttribute("employee", product);
		return "employee/show";
	}

	private Employee nullEmployee()
	{
		Employee employee = new Employee();
		employee.setPESEL("Not found");
		return employee;
	}
}
