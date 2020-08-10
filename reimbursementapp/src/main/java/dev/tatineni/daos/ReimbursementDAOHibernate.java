package dev.tatineni.daos;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dev.tatineni.entities.Employee;
import dev.tatineni.entities.Reimbursement;
import dev.tatineni.utils.HibernateUtil;

public class ReimbursementDAOHibernate implements ReimbursementDAO {
	
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		Session sess = sf.openSession(); // open a session
		sess.beginTransaction(); // begin a transaction
		
		
		sess.save(reimbursement); // this will save our director object		
		
		sess.getTransaction().commit(); // commit the transaction
		sess.close(); // close a session
		
		return reimbursement;
	
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		
		Session sess = sf.openSession();
		
		CriteriaQuery<Reimbursement> criteriaQuery = sess.getCriteriaBuilder().createQuery(Reimbursement.class);
	    criteriaQuery.from(Reimbursement.class);
	     
        List<Reimbursement> reimbursements = sess.createQuery(criteriaQuery).getResultList();
        
        sess.close();
        
  
		
		return reimbursements;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		Reimbursement currReimbursement = sess.load(Reimbursement.class, reimbursement.getrId());
		currReimbursement.setNote(reimbursement.getNote());
		currReimbursement.setStatus(reimbursement.getStatus());
		sess.update(currReimbursement);
		sess.getTransaction().commit();
		sess.close();
		
		return reimbursement;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reimbursement> getReimbursementsByEmployeeId(int id) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		
		String hql = "FROM Reimbursement r where r.eId='"+id +"'";
		Query q = sess.createQuery(hql);
		
		List<Reimbursement> reimbursements = q.getResultList();
		return reimbursements;

		
	
	}
	

}
