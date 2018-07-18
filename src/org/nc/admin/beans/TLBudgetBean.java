package org.nc.admin.beans;



public class TLBudgetBean {

	private int id;
	private int cxo_id_fk;	
	private String tl_name;
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
