package org.nc.admin.DaoImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.nc.admin.Dao.UserLoginDao;
import org.nc.admin.beans.ManagerBudgetBean;

import org.nc.admin.beans.TLBudgetBean;
import org.nc.admin.beans.TravelExpenseBean;
import org.nc.admin.beans.UsersBean;
import org.nc.entitybeans.ExpenseMaster;
import org.nc.entitybeans.ManagersBudget;
import org.nc.entitybeans.TLBudget;
import org.nc.entitybeans.UserRequest;
import org.nc.entitybeans.Users;
import org.springframework.beans.factory.annotation.Autowired;


public class UserLoginDaoImplementation implements UserLoginDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private String username_val_data = null;

	private String getNamebyUsername(String username, Session session) {
		Transaction transaction = null;
		List<Users> result = null;
		String username_val_db = "";
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query query = session.createQuery("from Users where username = '"+username+"'").setMaxResults(1);
			result = query.list();
			int result_size = result.size();
			if (result_size == 0) {
				username_val_data = "1";
			} else {
				for (Iterator it = result.iterator(); it.hasNext();) {
					Users ac = (Users) it.next();
					username_val_db = ac.getFirst_name()+" "+ac.getLast_name();
					username_val_data =username_val_db;
				}
			}
			transaction.commit();
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		} finally {
			session.clear();
			session.close();
		}
		//System.out.println("po_no_val_data :: "+po_no_val_data);
		return username_val_data;
	}


	/*@Override
	public String getRoleNewData(String username) {
		Transaction transaction = null;
		Session session = null;
		List<Users> result = null;
		String roleNew_val = "";
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query query = session.createQuery("from Users where username = '"+username+"'").setMaxResults(1);
			result = query.list();
			int result_size = result.size();
			if (result_size == 0) {
				username_val_data = "1";
			} else {
				for (Iterator it = result.iterator(); it.hasNext();) {
					Users ac = (Users) it.next();
					roleNew_val = ac.getRoleNew();
				}
			}
			transaction.commit();
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		} finally {
			session.clear();
			session.close();
		}
		//System.out.println("po_no_val_data :: "+po_no_val_data);
		return roleNew_val;
	}*/
	
	@Override
	public Users getRoleNewData(String username) {
		Transaction transaction = null;
		Session session = null;
		List<Users> result = null;
		Users user=null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query query = session.createQuery("from Users where username = '"+username+"'").setMaxResults(1);
			result = query.list();
			int result_size = result.size();
			if (result_size == 0) {
				username_val_data = "1";
			} else {
				for (Iterator it = result.iterator(); it.hasNext();) {
					user = (Users) it.next();					
				}
			}
			transaction.commit();
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		} finally {
			session.clear();
			session.close();
		}
		//System.out.println("po_no_val_data :: "+po_no_val_data);
		return user;
	}

/*	@Override
	public List<TravelExpenseBean> getMasterList() {
		List<TravelExpenseBean> master_list=null;
		List<ExpenseMaster> list= null;
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query query8=session.createQuery("from ExpenseMaster where manager_approval != '1' or manager_approval is null ");
			list=query8.list();
			master_list = new ArrayList<TravelExpenseBean>();
			for(Iterator it2 = list.iterator(); it2.hasNext();)
			{
				ExpenseMaster ex = (ExpenseMaster) it2.next();

				TravelExpenseBean bean = new TravelExpenseBean();
				bean.setId(ex.getId());
				bean.setEmployee_id(ex.getEmployee_id());
				bean.setEmployee_name(ex.getEmployee_name());
				bean.setDepartment(ex.getDepartment());
				bean.setManager_name(ex.getManager_name());
			
				bean.setTravelling_date_from(ex.getTravelling_date_from());
				bean.setTravelling_date_to(ex.getTravelling_date_to());
				bean.setTransport_type(ex.getTransport_type());
				bean.setReason_of_travel(ex.getReason_of_travel());
				bean.setTotal_expense_price(ex.getTotal_expense_price());
				
				master_list.add(bean);
			}
			
	 }catch(Exception ex) {
	   ex.printStackTrace();
	}
return master_list;
	}*/
	
	
	@Override
	public List<UsersBean> getMasterList() {
		List<UserRequest> list=null;
		Session session = null;
		Transaction transaction = null;
		List<UsersBean> userBeans =null;
		List objList;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();	    
			SQLQuery query1=session.createSQLQuery("SELECT u.first_name, u.last_name,u.email_id,r.estimated_amount,r.reimbursement_type,r.start_date,r.end_date,r.user_id,r.id,r.manager_approval FROM request r INNER JOIN users u ON r.user_id = u.user_id");
			
			objList=query1.list();
			userBeans = new ArrayList<UsersBean>();
			
			for(Iterator it2 = objList.iterator(); it2.hasNext();)
			{
				Object[] org = (Object[]) it2.next();
				UsersBean bean= new UsersBean();
				
				bean.setFirst_name(org[0].toString());
				bean.setLast_name(org[1].toString());
				bean.setEmail_address(org[2].toString());
				bean.setEstimated_amount(Long.parseLong(org[3].toString()));
				bean.setReimbursement_type(org[4].toString());
				bean.setStart_date(org[5].toString());
				bean.setEnd_date(org[6].toString());
				bean.setUser_id(org[7].toString());
				bean.setRequestId(Integer.parseInt(org[8].toString()));
				bean.setManager_approval(org[9].toString());
				userBeans.add(bean);
			}
			
			

			
			
	 }catch(Exception ex) {
	   ex.printStackTrace();
	}
	return userBeans;
}

	@Override
	public List<TravelExpenseBean> getMasterListForCFO() {
		
		List<TravelExpenseBean> master_list=null;
		List<ExpenseMaster> list= null;
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query query8=session.createQuery("from ExpenseMaster where manager_approval = '1' and cfo_processed is null ");
			list=query8.list();
			master_list = new ArrayList<TravelExpenseBean>();
			for(Iterator it2 = list.iterator(); it2.hasNext();)
			{
				ExpenseMaster ex = (ExpenseMaster) it2.next();

				TravelExpenseBean bean = new TravelExpenseBean();
				bean.setId(ex.getId());
				bean.setEmployee_id(ex.getEmployee_id());
				bean.setEmployee_name(ex.getEmployee_name());
				bean.setDepartment(ex.getDepartment());
				bean.setManager_name(ex.getManager_name());
			
				bean.setTravelling_date_from(ex.getTravelling_date_from());
				bean.setTravelling_date_to(ex.getTravelling_date_to());
				bean.setTransport_type(ex.getTransport_type());
				bean.setReason_of_travel(ex.getReason_of_travel());
				bean.setTotal_expense_price(ex.getTotal_expense_price());
				
				master_list.add(bean);
			}
			
	 }catch(Exception ex) {
	   ex.printStackTrace();
	}
return master_list;
	}

	@Override
	public List<ManagerBudgetBean> getManagerInfo(String username) {

		List<ManagerBudgetBean> master_list=null;
		List<ManagersBudget> list= null;
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query query8=session.createQuery("from ManagersBudget where tl_id_fk = 1");
			list=query8.list();
			master_list = new ArrayList<ManagerBudgetBean>();
			for(Iterator it2 = list.iterator(); it2.hasNext();)
			{
				ManagersBudget ex = (ManagersBudget) it2.next();

				ManagerBudgetBean bean = new ManagerBudgetBean();
				bean.setId(ex.getId());
				bean.setBudget_in_hand(ex.getBudget_in_hand());
				bean.setFrom(ex.getFrom_date());
				bean.setName(ex.getName());
				bean.setTo(ex.getTo_date());
				bean.setTotal_budget(ex.getTotal_budget());
				master_list.add(bean);
			}
			
	 }catch(Exception ex) {
	   ex.printStackTrace();
	}
		return master_list;

	}

	@Override
	public List<TLBudgetBean> getTLInfo(String username) {
		List<TLBudgetBean> master_list=null;
		List<TLBudget> list= null;
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query query8=session.createQuery("from TLBudget");
			list=query8.list();
			master_list = new ArrayList<TLBudgetBean>();
			for(Iterator it2 = list.iterator(); it2.hasNext();)
			{
				TLBudget ex = (TLBudget) it2.next();

				TLBudgetBean bean = new TLBudgetBean();
				bean.setId(ex.getId());
				bean.setBudget_in_hand(ex.getBudget_in_hand());
				bean.setFrom(ex.getFrom());
				bean.setTl_name(ex.getTl_name());
				bean.setTo(ex.getTo());
				bean.setTotal_budget(ex.getTotal_budget());
				master_list.add(bean);
			}
			
	 }catch(Exception ex) {
	   ex.printStackTrace();
	}
		return master_list;
		
	}

	@Override
	public List<UsersBean> getUserExpensesByManagerWise(int manager_id) {
		List<UsersBean> master_list=null;
		List list = null;
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			list=new ArrayList<>();
			SQLQuery query8=session.createSQLQuery("select concat(u.first_name,' ',u.last_name) as User_Name,u.email_id,r.estimated_amount,r.summary,r.start_date,r.end_date from request r " + 
					"inner join users u on u.user_id = r.user_id where manager_approval = '0' and manager_id_fk = "+manager_id+"");
			list=query8.list();
			master_list = new ArrayList<UsersBean>();
			for(Iterator it2 = list.iterator(); it2.hasNext();)
			{
				Object[] org = (Object[]) it2.next();
				UsersBean bean = new UsersBean();
			    bean.setEmpName(org[0].toString());
			    bean.setEmail_address(org[1].toString());
			    bean.setEstimated_amount(Long.parseLong(org[2].toString()));
			    bean.setSummary(org[3].toString());
			    bean.setStart_date(org[4].toString());
			    bean.setEnd_date(org[5].toString());
			    
			    master_list.add(bean);
				
			}
			
	 }catch(Exception ex) {
	   ex.printStackTrace();
	}
		return master_list;
		

	}
	
	
	public ManagersBudget getManagerDetailByManagerId(String manager_id) {
		List<ManagersBudget> list= null;
		Session session = null;
		Transaction transaction = null;


		ManagersBudget managerBudget =null;
		try {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		managerBudget =new ManagersBudget();
		Query query6=session.createQuery("from ManagersBudget where id="+manager_id+"");
		list=query6.list();

		for(Iterator it2 = list.iterator(); it2.hasNext();)
		{
			managerBudget = (ManagersBudget) it2.next();	
		}

		}catch(Exception ex) {
		  ex.printStackTrace();
		}


		return managerBudget;
		}

	
	
	
}
