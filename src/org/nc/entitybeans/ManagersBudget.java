package org.nc.entitybeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager_budget")
public class ManagersBudget {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, length=11)
	private int id;
	
	@Column(name="tl_id_fk", nullable=true, length=11)
	private int tl_id_fk;	
	
	@Column(name="name", nullable=true, length=255)
	private String name;
	
	@Column(name="total_budget", nullable=true, length=11)
	private int total_budget;

	@Column(name="budget_in_hand", nullable=true, length=11)
	private int budget_in_hand;

	@Column(name="from_date", nullable=true, length=255)
	private String from_date;
	
	@Column(name="to_date", nullable=true, length=255)
	private String to_date;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTl_id_fk() {
		return tl_id_fk;
	}

	public void setTl_id_fk(int tl_id_fk) {
		this.tl_id_fk = tl_id_fk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal_budget() {
		return total_budget;
	}

	public void setTotal_budget(int total_budget) {
		this.total_budget = total_budget;
	}

	public int getBudget_in_hand() {
		return budget_in_hand;
	}

	public void setBudget_in_hand(int budget_in_hand) {
		this.budget_in_hand = budget_in_hand;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	
	
	
	
	
	
}
