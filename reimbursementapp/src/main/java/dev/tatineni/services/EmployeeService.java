package dev.tatineni.services;

import dev.tatineni.entities.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	
	int loginEmployee(String username,String password);
	
	boolean loginEmployeeManager(String username, String password);

}
