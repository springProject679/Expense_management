package org.nc.admin.beans;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.nc.entitybeans.UserRequest;

public class UsersBean {
	private String first_name;
	private String last_name;
	private String mobile_no;
	private String email_address;
	private String password;
	private String role;
	private String username;
	private String user_id;
	private String employee_code;
	private Date created_date;
	
	private String empName;
	private String summary;
	private String managerID;
	private String manager_name;
	private String manager_approval;
	private long estimated_amount;
	private List<UserRequest> userRequests;

	private String start_date;
	private String end_date;
	
	//private String estimated_amount;
	private String reimbursement_type;
	private int requestId;
	
	
	
	
	public String getReimbursement_type() {
		return reimbursement_type;
	}
	public void setReimbursement_type(String reimbursement_type) {
		this.reimbursement_type = reimbursement_type;
	}

	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public List<UserRequest> getUserRequests() {
		return userRequests;
	}
	public void setUserRequests(List<UserRequest> list) {
		this.userRequests = list;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	
	
	
	public long getEstimated_amount() {
		return estimated_amount;
	}
	public void setEstimated_amount(long estimated_amount) {
		this.estimated_amount = estimated_amount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getManagerID() {
		return managerID;
	}
	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	public String getManager_approval() {
		return manager_approval;
	}
	public void setManager_approval(String manager_approval) {
		this.manager_approval = manager_approval;
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
	

}
