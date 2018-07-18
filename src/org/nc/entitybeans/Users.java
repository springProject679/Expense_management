package org.nc.entitybeans;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users implements Serializable {
	  @Id
	    @GeneratedValue
	    @Column(name="user_id", nullable=false, length=11)
	    private int user_id;
	    @Column(name="username",unique = true, nullable=false, length=200)
	    private String username;
	    
	    @Column(name="password", nullable=true, length=200)
	    private String password;
	    @Column(name="enabled", nullable=true, length=200)
	    private int enabled;	    
	    @Column(name="hash_verification", nullable=true, length=200)
	    private String hash_verification;
	    @Column(name="role", nullable=true, length=50)
	    private String role;
	    @Column(name="has_logged_in_first_time", nullable=true, length=1)
	    private int has_logged_in_first_time;
	    
	    @Column(name="mobile_no", nullable=true, length=200)
	    private String mobile_no;
	    
	    @Column(name="email_id", nullable=true, length=200)
	    private String email_id;
	    
	     @Column(name="custom_user_id", nullable=true, length=200)
	    private String custom_user_id;
	   
	     @Column(name="employee_code", nullable=true, length=255)
	 	private String employee_code;
	    
	    @Column(name="first_name", nullable=true, length=200)
	    private String first_name;
	    
	    @Column(name="last_name", nullable=true, length=200)
	    private String last_name;
	  
	    private Date date=new Date();
	    
	    @Column(name="roleNew", nullable=true, length=50)
	    private String roleNew;
	    
	    @Column(name="manager_id")
	    private String manager_id;
	    
	    @Column(name="manager_name")
	    private String manager_name;
	    
	    @Column(name="manager_email_id")
	    private String manager_email_id;
	    
	    @Column(name="created_date", nullable= true, length=50)
		private Date created_date;
	    
	    
	    
	    

		public String getManager_id() {
			return manager_id;
		}

		public void setManager_id(String manager_id) {
			this.manager_id = manager_id;
		}

		public String getManager_name() {
			return manager_name;
		}

		public void setManager_name(String manager_name) {
			this.manager_name = manager_name;
		}

		public String getManager_email_id() {
			return manager_email_id;
		}

		public void setManager_email_id(String manager_email_id) {
			this.manager_email_id = manager_email_id;
		}

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getEnabled() {
			return enabled;
		}

		public void setEnabled(int enabled) {
			this.enabled = enabled;
		}

		public String getHash_verification() {
			return hash_verification;
		}

		public void setHash_verification(String hash_verification) {
			this.hash_verification = hash_verification;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public int getHas_logged_in_first_time() {
			return has_logged_in_first_time;
		}

		public void setHas_logged_in_first_time(int has_logged_in_first_time) {
			this.has_logged_in_first_time = has_logged_in_first_time;
		}

		public String getMobile_no() {
			return mobile_no;
		}

		public void setMobile_no(String mobile_no) {
			this.mobile_no = mobile_no;
		}

		public String getEmail_id() {
			return email_id;
		}

		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}

		public String getCustom_user_id() {
			return custom_user_id;
		}

		public void setCustom_user_id(String custom_user_id) {
			this.custom_user_id = custom_user_id;
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

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getRoleNew() {
			return roleNew;
		}

		public void setRoleNew(String roleNew) {
			this.roleNew = roleNew;
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
    
    
    
}