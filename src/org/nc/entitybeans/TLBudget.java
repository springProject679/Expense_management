package org.nc.entitybeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tl_budget")
public class TLBudget {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, length=11)
	private int id;
	
	@Column(name="cxo_id_fk", nullable=true, length=11)
	private int cxo_id_fk;	
	
	@Column(name="tl_name", nullable=true, length=255)
	private String tl_name;
	
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

	public int getCxo_id_fk() {
		return cxo_id_fk;
	}

	public void setCxo_id_fk(int cxo_id_fk) {
		this.cxo_id_fk = cxo_id_fk;
	}

	public String getTl_name() {
		return tl_name;
	}

	public void setTl_name(String tl_name) {
		this.tl_name = tl_name;
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
