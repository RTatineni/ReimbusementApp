package dev.tatineni.servicetests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import dev.tatineni.daos.EmployeeDAO;
import dev.tatineni.daos.ReimbursementDAO;
import dev.tatineni.entities.Employee;
import dev.tatineni.entities.Reimbursement;
import dev.tatineni.services.EmployeeService;
import dev.tatineni.services.EmployeeServiceImpl;
import dev.tatineni.services.ReimbursementService;
import dev.tatineni.services.ReimbursementServiceImpl;

public class ReimbursementServiceTests {
	
	@Test
	void mockedDaoTest() {
		
		Employee fakeBob = new Employee(0,"Rajiv",1,"raj","password");
			
		Reimbursement fakeRei = new Reimbursement(1,200,"pending","Im sick","");
		
		// Create Fake arrays
		List<Reimbursement> fakeReimbursements = new ArrayList<Reimbursement>();
		List<Employee> fakeEmployees = new ArrayList<Employee>();
		
		fakeEmployees.add(fakeBob);
		fakeReimbursements.add(fakeRei);
		
		
		// MOCK fake DAOS
		EmployeeDAO edao = Mockito.mock(EmployeeDAO.class);
		ReimbursementDAO rdao = Mockito.mock(ReimbursementDAO.class);
		
		
		// Call actual service tests
		
		//Mockito.when(rdao.getAllReimbursements()).thenReturn(fakeReimbursements);
		
		// Verify this service actually works with mocked dao
		
		
		Mockito.when(rdao.getAllReimbursements()).thenReturn(fakeReimbursements);
		
		Mockito.when(edao.loginEmployee("raj","password")).thenReturn(1);
		
		ReimbursementService rserv = new ReimbursementServiceImpl(edao,rdao);
		EmployeeService eserv = new EmployeeServiceImpl(edao,rdao);

		//	List<Reimbursement> reis = rserv.getAllReimbursements();
		List<Reimbursement> reis = rserv.getAllReimbursements();

		int employ = eserv.loginEmployee("raj", "password"); 
		// Should print reimbursements
		//System.out.println(reis);
		//System.out.println(fakeReimbursements);
		
		Assertions.assertEquals(fakeReimbursements,reis);
		Assertions.assertEquals(1, employ);
		
		
	}


}
