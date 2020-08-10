package dev.tatineni.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="reimbursement")
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="r_id")
	private int rId;
	
	@Column(name="e_id")
	private int eId;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="status")
	private String status;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="note")
	private String note;

	
	public Reimbursement() {
		super();
	}


	public Reimbursement(int eId, int amount, String status, String reason, String note) {
		super();
	//	this.rId = rId;
		this.eId = eId;
		this.amount = amount;
		this.status = status;
		this.reason = reason;
		this.note = note;
	}


	public int getrId() {
		return rId;
	}


	public void setrId(int rId) {
		this.rId = rId;
	}


	public int geteId() {
		return eId;
	}


	public void seteId(int eId) {
		this.eId = eId;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", eId=" + eId + ", amount=" + amount + ", status=" + status + ", reason="
				+ reason + ", note=" + note + "]";
	}





}














