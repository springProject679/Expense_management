package org.nc.admin.ServiceImplementation;

import java.util.List;

import org.nc.admin.DaoImplementation.UserLoginDaoImplementation;
import org.nc.admin.Service.UserLoginService;
import org.nc.admin.beans.ManagerBudgetBean;
import org.nc.admin.beans.SuperCompanyBean;
import org.nc.admin.beans.TLBudgetBean;
import org.nc.admin.beans.TravelExpenseBean;
import org.nc.admin.beans.UsersBean;
import org.nc.entitybeans.ManagersBudget;
import org.nc.entitybeans.UserRequest;
import org.nc.entitybeans.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserLoginServiceImplementation implements UserLoginService {
	
	@Autowired
	@Qualifier("userLoginDaoImplementation")
	private UserLoginDaoImplementation userLoginDaoImplementation;

	public UserLoginDaoImplementation getUserLoginDaoImplementation() {
		return userLoginDaoImplementation;
	}
	
	public void setUserLoginDaoImplementation(
			UserLoginDaoImplementation userLoginDaoImplementation) {
		this.userLoginDaoImplementation = userLoginDaoImplementation;
	}
	
/*	@Override
	public String getRoleNewData(String username) {
		return this.userLoginDaoImplementation.getRoleNewData(username);
	}*/
	
	@Override
	public Users getRoleNewData(String username) {
		return this.userLoginDaoImplementation.getRoleNewData(username);
	}

	@Override
	public List<UsersBean> getMasterList() {
		return this.userLoginDaoImplementation.getMasterList();
	}

	public List<TravelExpenseBean> getMasterListForCFO() {
		return this.userLoginDaoImplementation.getMasterListForCFO();
	}

	@Override
	public List<ManagerBudgetBean> getManagerInfo(String username) {
		return this.userLoginDaoImplementation.getManagerInfo(username);
	}

	@Override
	public List<TLBudgetBean> getTLInfo(String username) {
		return this.userLoginDaoImplementation.getTLInfo(username);
	}

	@Override
	public List<UsersBean> getUserExpensesByManagerWise(int manager_id) {
		return this.userLoginDaoImplementation.getUserExpensesByManagerWise(manager_id);
	}
	
	 public ManagersBudget getManagerDetail(String manager_id) {
		// TODO Auto-generated method stub
		return this.userLoginDaoImplementation.getManagerDetailByManagerId(manager_id);
		}
	
	 
}
