package org.nc.admin.beans;

import java.util.List;

import javax.persistence.Column;

public class TravelExpenseBean 
{
	
	private String employee_name;
	
	
	private String employee_id;
	
	
	private String manager_name;
	
	
	private String division;
	
	
	private String department;
	
	
	private String designation;
	
	
	private String travelling_from;
	
	
	private String travelling_to;
	private String travelling_date_from;
	private String travelling_date_to;
	private String transport_type;
	private String reason_of_travel;
	private long total_expense_price;
	
	private List<String> date_of_event;
	private List<String> description;
	private List<String> amount;
	private List<String> attachment;
	
	private String single_date_of_event;
	private String single_description;
	private String single_amount;
	
	private int id;
	
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getTravelling_from() {
		return travelling_from;
	}
	public void setTravelling_from(String travelling_from) {
		this.travelling_from = travelling_from;
	}
	public String getTravelling_to() {
		return travelling_to;
	}
	public void setTravelling_to(String travelling_to) {
		this.travelling_to = travelling_to;
	}
	public String getTravelling_date_from() {
		return travelling_date_from;
	}
	public void setTravelling_date_from(String travelling_date_from) {
		this.travelling_date_from = travelling_date_from;
	}
	public String getTravelling_date_to() {
		return travelling_date_to;
	}
	public void setTravelling_date_to(String travelling_date_to) {
		this.travelling_date_to = travelling_date_to;
	}
	public String getTransport_type() {
		return transport_type;
	}
	public void setTransport_type(String transport_type) {
		this.transport_type = transport_type;
	}
	public String getReason_of_travel() {
		return reason_of_travel;
	}
	public void setReason_of_travel(String reason_of_travel) {
		this.reason_of_travel = reason_of_travel;
	}
	public long getTotal_expense_price() {
		return total_expense_price;
	}
	public void setTotal_expense_price(long total_expense_price) {
		this.total_expense_price = total_expense_price;
	}
	public List<String> getDate_of_event() {
		return date_of_event;
	}
	public void setDate_of_event(List<String> date_of_event) {
		this.date_of_event = date_of_event;
	}
	public List<String> getDescription() {
		return description;
	}
	public void setDescription(List<String> description) {
		this.description = description;
	}
	public List<String> getAmount() {
		return amount;
	}
	public void setAmount(List<String> amount) {
		this.amount = amount;
	}
	public List<String> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<String> attachment) {
		this.attachment = attachment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSingle_date_of_event() {
		return single_date_of_event;
	}
	public void setSingle_date_of_event(String single_date_of_event) {
		this.single_date_of_event = single_date_of_event;
	}
	public String getSingle_description() {
		return single_description;
	}
	public void setSingle_description(String single_description) {
		this.single_description = single_description;
	}
	public String getSingle_amount() {
		return single_amount;
	}
	public void setSingle_amount(String single_amount) {
		this.single_amount = single_amount;
	}
	
	
	
	
	
}


