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
	@Secured({"ROLE_admin", "ROLE_brygadzista", "ROLE_manager_zatrudnienia"})
	public String index()
	{
		return "employee/index";
	}

	@RequestMapping({"/create", "/create/"})
	@Secured({"ROLE_admin", "ROLE_manager_zatrudnienia"})
	public String create()
	{
		return "employee/create";
	}

	@RequestMapping({"/{PESEL}", "/{PESEL}/"})
	@Secured({"ROLE_admin", "ROLE_brygadzista", "ROLE_manager_zatrudnienia"})
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

	@RequestMapping({"/{PESEL}/delete", "/{PESEL}/delete/"})
	public String delete(@PathVariable String PESEL)
	{
		employeeRepository.deleteById(PESEL);
		return "redirect:/employee/";
	}
}
