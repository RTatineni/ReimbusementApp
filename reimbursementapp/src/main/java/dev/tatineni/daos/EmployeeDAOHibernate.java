package dev.tatineni.daos;

import dev.tatineni.entities.Employee;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



import dev.tatineni.utils.HibernateUtil;

public class EmployeeDAOHibernate implements EmployeeDAO {

	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Override
	public Employee createEmployee(Employee employee) {
		Session sess = sf.openSession(); // open a session
		sess.beginTransaction(); // begin a transaction
		
		
		sess.save(employee); // this will save our director object		
		
		sess.getTransaction().commit(); // commit the transaction
		sess.close(); // close a session
		
		return employee;
	
	}

	@Override
	public int loginEmployee(String username, String password) {
		// Find if an entry in database exists with given username
		
		Session sess = sf.openSession();
	
		CriteriaQuery<Employee> criteriaQuery = sess.getCriteriaBuilder().createQuery(Employee.class);
	    criteriaQuery.from(Employee.class);
	     
        List<Employee> employees = sess.createQuery(criteriaQuery).getResultList();
        sess.close();
        
        
        for(Employee e: employees) {
        	System.out.println(e.getUsername());
        	if(e.getUsername().equals(username)) {
        		if(e.getPassword().equals(password)) {
        			return e.geteId();
        		}
        	}
        }

		
		return 0;
	}
	
	@Override
	public boolean loginEmployeeManager(String username, String password) {
		// Validate that user exists and check user name and password for accurate match 
		Session sess = sf.openSession();
		
		CriteriaQuery<Employee> criteriaQuery = sess.getCriteriaBuilder().createQuery(Employee.class);
	    criteriaQuery.from(Employee.class);
	     
        List<Employee> employees = sess.createQuery(criteriaQuery).getResultList();
        sess.close();
        
        
        for(Employee e: employees) {
        	System.out.println(e.getUsername());
        	if(e.getUsername().equals(username)) {
        		if(e.getPassword().equals(password)) {
        			
        			
        			if(e.getmId() == 0) {
        				return true;
        			}
        		}
        	}
        }

		
		return false;
	}
	
	


}
