package org.nc.entitybeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expense_master")
public class ExpenseMaster 
{
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, length=11)
	private int id;
	
	@Column(name="employee_name", nullable=true, length=255)
	private String employee_name;
	
	@Column(name="employee_id", nullable=true, length=255)
	private String employee_id;
	
	@Column(name="manager_name", nullable=true, length=255)
	private String manager_name;
	
	@Column(name="division", nullable=true, length=255)
	private String division;
	
	@Column(name="department", nullable=true, length=255)
	private String department;
	
	@Column(name="designation", nullable=true, length=255)
	private String designation;
	
	@Column(name="travelling_from", nullable=true, length=255)
	private String travelling_from;
	
	@Column(name="travelling_to", nullable=true, length=255)
	private String travelling_to;
	
	@Column(name="travelling_date_from", nullable=true, length=255)
	private String travelling_date_from;
	
	@Column(name="travelling_date_to", nullable=true, length=255)
	private String travelling_date_to;
	
	@Column(name="transport_type", nullable=true, length=255)
	private String transport_type;
	
	@Column(name="reason_of_travel", nullable=true, length=255)
	private String reason_of_travel;
	
	@Column(name="total_expense_price", nullable=true, length=20)
	private long total_expense_price;
	
	@Column(name="manager_approval", nullable=true, length=255)
	private String manager_approval;

	@Column(name="cfo_processed", nullable=true, length=255)
	private String cfo_processed;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getManager_approval() {
		return manager_approval;
	}

	public void setManager_approval(String manager_approval) {
		this.manager_approval = manager_approval;
	}

	public String getCfo_processed() {
		return cfo_processed;
	}

	public void setCfo_processed(String cfo_processed) {
		this.cfo_processed = cfo_processed;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
