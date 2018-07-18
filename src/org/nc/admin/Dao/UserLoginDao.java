package org.nc.admin.Dao;

import java.util.List;

import org.nc.admin.beans.ManagerBudgetBean;
import org.nc.admin.beans.SuperCompanyBean;
import org.nc.admin.beans.TLBudgetBean;
import org.nc.admin.beans.TravelExpenseBean;
import org.nc.admin.beans.UsersBean;
import org.nc.entitybeans.UserRequest;
import org.nc.entitybeans.Users;

public interface UserLoginDao {
	
	
	public Users getRoleNewData(String username);

	public List<UsersBean> getMasterList();

	public List<TravelExpenseBean> getMasterListForCFO();

	public List<ManagerBudgetBean> getManagerInfo(String username);

	public List<TLBudgetBean> getTLInfo(String username);

	public List<UsersBean> getUserExpensesByManagerWise(int manager_id);

	
	
}
