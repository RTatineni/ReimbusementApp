package dev.tatineni.services;

import dev.tatineni.daos.EmployeeDAO;
import dev.tatineni.daos.EmployeeDAOHibernate;
import dev.tatineni.daos.ReimbursementDAO;
import dev.tatineni.entities.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	
	public EmployeeDAO edao = new EmployeeDAOHibernate();
	private EmployeeDAO eedao;
	private ReimbursementDAO rrdao;
	
	public EmployeeServiceImpl() {
		super();
	}
	
	public EmployeeServiceImpl(EmployeeDAO edao, ReimbursementDAO rdao) {
		this.eedao = edao;
		this.rrdao = rdao;
		
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		return this.edao.createEmployee(employee);
	}

	
	@Override
	public int loginEmployee(String username, String password) {
		if(this.eedao != null) {
			return this.eedao.loginEmployee(username, password);
		}
		else {
			return this.edao.loginEmployee(username, password);

		}
	}


	@Override
	public boolean loginEmployeeManager(String username, String password) {
		return this.edao.loginEmployeeManager(username, password);
	}
}
