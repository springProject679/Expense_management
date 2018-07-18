package org.nc.admin.beans;

public class RequestBean {
	private int id;
	public String getEmpID() {
		return EmpID;
	}
	public void setEmpID(String empID) {
		EmpID = empID;
	}
	private String EmpID;
	private String EmpName;
	private String summary;
	
	private String EmailId;
	private String ManagerID;
	private String manager_name;
	private String Manager_approval;
	private Long estimated_amount;
	
	public Long getEstimated_amount() {
		return estimated_amount;
	}
	public void setEstimated_amount(Long estimated_amount) {
		this.estimated_amount = estimated_amount;
	}
	public String getManager_approval() {
		return Manager_approval;
	}
	public void setManager_approval(String manager_approval) {
		Manager_approval = manager_approval;
	}
	public String getManagerID() {
		return ManagerID;
	}
	public void setManagerID(String managerID) {
		ManagerID = managerID;
	}
	
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

}
