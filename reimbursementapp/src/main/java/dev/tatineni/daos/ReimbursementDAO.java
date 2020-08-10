package dev.tatineni.daos;

import java.util.List;
import java.util.Set;

import dev.tatineni.entities.Employee;
import dev.tatineni.entities.Reimbursement;

public interface ReimbursementDAO {
	// Create
	Reimbursement createReimbursement(Reimbursement reimbursement);
	
	List<Reimbursement> getAllReimbursements();
	
	Reimbursement updateReimbursement(Reimbursement reimbursement);
	
	List<Reimbursement> getReimbursementsByEmployeeId(int id);
}
