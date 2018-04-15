package edu.bsk.database.repositories;

import edu.bsk.database.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String>
{
}
