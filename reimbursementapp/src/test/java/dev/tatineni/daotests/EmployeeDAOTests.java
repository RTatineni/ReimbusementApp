package dev.tatineni.daotests;
import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;


import dev.tatineni.daos.EmployeeDAO;
import dev.tatineni.daos.EmployeeDAOHibernate;
import dev.tatineni.entities.Employee;

@TestMethodOrder(OrderAnnotation.class) 
class EmployeeDAOTests {

	private static EmployeeDAO edao = new EmployeeDAOHibernate();
	

	
	
	@Test
	@Order(1)
	void createEmployee() {
		Employee bobby = new Employee(0,"bob",0,"bob","password");
		edao.createEmployee(bobby);
		Assertions.assertNotEquals(0,bobby.geteId());
	}
	
	@Test
	@Order(2)
	void loginEmployee() {
		// Create a employee
		Employee bob = new Employee(0,"bob",0,"bob","password");
		int status = edao.loginEmployee("bob","password");
		Assertions.assertNotEquals(0,status);
	}
	
	
	@Test
	@Order(3)
	void loginEmployeeManager() {
		// create a manager
		Employee bob = new Employee(0,"bob",0,"bob","password");
		edao.createEmployee(bob);
		
		// Login as bob and ensure he is a manager
		boolean status = edao.loginEmployeeManager("bob", "password");
		Assertions.assertEquals(true, status);

	}
	
	
}
