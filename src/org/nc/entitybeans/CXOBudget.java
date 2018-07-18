package org.nc.entitybeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cxo_budget")
public class CXOBudget {
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, length=11)
	private int id;
	
	@Column(name="name", nullable=true, length=255)
	private String name;
	
	@Column(name="total_budget", nullable=true, length=11)
	private int total_budget;

	@Column(name="budget_in_hand", nullable=true, length=11)
	private int budget_in_hand;

	@Column(name="from", nullable=true, length=255)
	private String from;
	
	@Column(name="to", nullable=true, length=255)
	private String to;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	
}

