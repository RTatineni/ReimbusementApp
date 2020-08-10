package dev.tatineni.daotests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import dev.tatineni.daos.ReimbursementDAO;
import dev.tatineni.daos.ReimbursementDAOHibernate;
import dev.tatineni.entities.Reimbursement;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;



@TestMethodOrder(OrderAnnotation.class) 
class ReimbursementDAOTests {

	
	private static ReimbursementDAO rdao = new ReimbursementDAOHibernate();
	
	

	@Test
	@Order(1)
	void createReimbursement() {
	
		
		
		Reimbursement r = new Reimbursement(1,200,"pending","test test","");
		
		rdao.createReimbursement(r);
		Assertions.assertNotEquals(0,r.getrId());

	}
	
	@Test
	@Order(2)
	void getAllReimbursements() {
		List<Reimbursement> reimburse = rdao.getAllReimbursements();
		Assertions.assertNotEquals(0,reimburse.size());
	}
	
	@Test
	@Order(3)
	void updateReimbursement() {
		Reimbursement r = new Reimbursement(1,200,"pending","testing testing","");
		
		rdao.createReimbursement(r);
		
		r.setAmount(999);
		rdao.updateReimbursement(r);
		Assertions.assertEquals(999,r.getAmount());
	}
	
	@Test
	@Order(4)
	void getReimbursementByEmployeeId() {
		List<Reimbursement> reimburse = rdao.getReimbursementsByEmployeeId(1);
		Assertions.assertNotEquals(0, reimburse.size());
	}

}
