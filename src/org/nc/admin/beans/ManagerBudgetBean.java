package org.nc.admin.beans;

import javax.persistence.Column;

public class ManagerBudgetBean {

	private int id;
	private int tl_id_fk;	
	private String name;
	private int total_budget;
	private int budget_in_hand;
	private String from;
	private String to;
	
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
