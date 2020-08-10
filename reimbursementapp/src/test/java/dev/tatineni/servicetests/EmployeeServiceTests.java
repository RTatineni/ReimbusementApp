package dev.tatineni.servicetests;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import dev.tatineni.entities.Employee;
import dev.tatineni.services.EmployeeService;
import dev.tatineni.services.EmployeeServiceImpl;

public class EmployeeServiceTests {
	
	public static EmployeeService empServ = new EmployeeServiceImpl(); 
	
	@Test
	void createEmployeeTest() {
		Employee e = new Employee(0,"bob",0,"bob","password");
		empServ.createEmployee(e);
	}
	
	@Test
	void loginEmployeeTest() {
		
		empServ.loginEmployee("bob", "password");
		
	}
	
	
	@Test
	void loginEmployeeManagerTest() {
		
		empServ.loginEmployeeManager("bob", "password");
		
	}
}
