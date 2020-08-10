package dev.tatineni.daos;

import dev.tatineni.entities.Employee;

public interface EmployeeDAO {

	// Create
	Employee createEmployee(Employee employee);
	
	// Login for regular Employee
	int loginEmployee(String username, String password);
	
	// Login for Manager type Employee
	public boolean loginEmployeeManager(String username, String password);

}
