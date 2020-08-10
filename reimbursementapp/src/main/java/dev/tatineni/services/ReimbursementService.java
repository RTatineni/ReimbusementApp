package dev.tatineni.services;


import java.util.List;
import java.util.Set;

import dev.tatineni.entities.Employee;
import dev.tatineni.entities.Reimbursement;

public interface ReimbursementService {
	
	Reimbursement createReimbursement(Reimbursement reimbursement);

	List<Reimbursement> getAllReimbursements();
	
	Reimbursement updateReimbursement(Reimbursement reimbursement);
	
	List<Reimbursement> getReimbursementsByEmployeeId(int id);
}
