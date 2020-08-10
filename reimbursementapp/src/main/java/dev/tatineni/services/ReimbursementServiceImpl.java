package dev.tatineni.services;


import java.util.List;
import java.util.Set;

import dev.tatineni.daos.EmployeeDAO;
import dev.tatineni.daos.ReimbursementDAO;
import dev.tatineni.daos.ReimbursementDAOHibernate;
import dev.tatineni.entities.Employee;
import dev.tatineni.entities.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {

	public ReimbursementDAO rdao = new ReimbursementDAOHibernate();

	private EmployeeDAO eedao;
	private ReimbursementDAO rrdao;
	
	public ReimbursementServiceImpl() {
		super();
	}
	
	public ReimbursementServiceImpl(EmployeeDAO edao,ReimbursementDAO rdao) {
		this.eedao = edao;
		this.rrdao = rdao;
	}
	
	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		return this.rdao.createReimbursement(reimbursement);
	}


	@Override
	public List<Reimbursement> getAllReimbursements() {
		if(this.rrdao != null) {
			return this.rrdao.getAllReimbursements();
		}
		else {
			return this.rdao.getAllReimbursements();

		}
	}
	
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		return this.rdao.updateReimbursement(reimbursement);
	}


	@Override
	public List<Reimbursement> getReimbursementsByEmployeeId(int id) {
		return this.rdao.getReimbursementsByEmployeeId(id);
	}

}
