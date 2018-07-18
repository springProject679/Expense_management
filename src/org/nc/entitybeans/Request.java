package org.nc.entitybeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Request")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, length=11)
	private int id;
	
	@Column(name="Manager_approval", nullable=true, length=255)
	private String Manager_approval;	
		
	@Column(name="estimated_amount", nullable=true, length=255)
	private Long estimated_amount;
	
	@Column(name="summary", nullable=true, length=255)
	private String summary;
	
	@Column(name="user_id", nullable=false, length=11)
	private int user_id;
	
	@Column(name="reimbursement_type", nullable=true, length=255)
	private String reimbursement_type;
	
	@Column(name="start_date", nullable=true, length=255)
	private String start_date;
	
	@Column(name="end_date", nullable=true, length=255)
	private String end_date;
	
	@Column(name="manager_id_fk", nullable=true, length=11)
	private int manager_id_fk;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManager_approval() {
		return Manager_approval;
	}

	public void setManager_approval(String manager_approval) {
		Manager_approval = manager_approval;
	}

	public Long getEstimated_amount() {
		return estimated_amount;
	}

	public void setEstimated_amount(Long estimated_amount) {
		this.estimated_amount = estimated_amount;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getReimbursement_type() {
		return reimbursement_type;
	}

	public void setReimbursement_type(String reimbursement_type) {
		this.reimbursement_type = reimbursement_type;
	}

	
	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getManager_id_fk() {
		return manager_id_fk;
	}

	public void setManager_id_fk(int manager_id_fk) {
		this.manager_id_fk = manager_id_fk;
	}


	
}
