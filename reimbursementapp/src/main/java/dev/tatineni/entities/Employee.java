package dev.tatineni.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="e_id")
	private int eId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "m_id")
	private int mId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany
	private Set<Reimbursement> reimbursements = new HashSet<Reimbursement>();
	
	public Employee() {
		super();
	}


	public Employee(int eId, String name, int mId, String username, String password) {
		super();
		this.eId = eId;
		this.name = name;
		this.mId = mId;
		this.username = username;
		this.password = password;
	}

	



	public Set<Reimbursement> getReimbursements() {
		return reimbursements;
	}


	public void setReimbursements(Set<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}


	public int geteId() {
		return eId;
	}


	public void seteId(int eId) {
		this.eId = eId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getmId() {
		return mId;
	}


	public void setmId(int mId) {
		this.mId = mId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", name=" + name + ", mId=" + mId + ", username=" + username + ", password="
				+ password + "]";
	}




	
	
	
}
