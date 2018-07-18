package org.nc.admin.ServiceImplementation;

import java.util.List;

import org.nc.admin.DaoImplementation.UserDaoImplementation;
import org.nc.admin.Service.UserService;
import org.nc.admin.beans.CourseBean;
import org.nc.admin.beans.RequestBean;
import org.nc.admin.beans.SuperCompanyBean;
import org.nc.admin.beans.TemplateBean;
import org.nc.admin.beans.TravelExpenseBean;
import org.nc.entitybeans.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceImplementation implements UserService {

	@Autowired
	@Qualifier("userDaoImplementation")
	private UserDaoImplementation userDaoImplementation;

	public UserDaoImplementation getUserDaoImplementation() {
		return userDaoImplementation;
	}

	public void setUserDaoImplementation(UserDaoImplementation userDaoImplementation) {
		this.userDaoImplementation = userDaoImplementation;
	}

	@Override
	public boolean CreateReembersement(TravelExpenseBean bean) {
		return this.userDaoImplementation.CreateReembersement(bean);
	}

	@Override
	public List<TravelExpenseBean> getList(int master_id) {
		return this.userDaoImplementation.getList(master_id);
	}

	@Override
	public List<TravelExpenseBean> getListofMasterData(int master_id) {
		return this.userDaoImplementation.getListofMasterData(master_id);
	}

	@Override
	public boolean Approve_Reermberse(TravelExpenseBean bean) {
		return this.userDaoImplementation.Approve_Reermberse(bean);
	}
	@Override
	public boolean Reject_Reermberse(TravelExpenseBean bean) {
		return this.userDaoImplementation.Reject_Reermberse(bean);
	}

	@Override
	public boolean requestform(UserRequest bean) {
		return this.userDaoImplementation.requestform(bean);
	}

	@Override
	public boolean approvalRequest(int id,int newBudgetInHand) {
		
		return this.userDaoImplementation.approvalRequest(id,newBudgetInHand);
	}

    /*@Override
	public boolean CreateCompany(SuperCompanyBean bean) {
    	return this.userDaoImplementation.CreateCompany(bean);
	}

    @Override
	public List<SuperCompanyBean> getCompanyList() {
    	return this.userDaoImplementation.getCompanyList();
	}

    @Override
	public List<SuperCompanyBean> getCompanyData(int id) {
    	return this.userDaoImplementation.getCompanyData(id);
	}

    @Override
	public boolean UpdateCompany(SuperCompanyBean bean) {
    	return this.userDaoImplementation.UpdateCompany(bean);
	}
    
    @Override
    public boolean addtemplate(TemplateBean beans) {
		return this.userDaoImplementation.addtemplate(beans);
	}

	@Override
	public List<TemplateBean> getTemplateList() {
		return this.userDaoImplementation.getTemplateList();
	}

	@Override
	public List<TemplateBean> getTemplateData(int template_id) {
		
		return this.userDaoImplementation.getTemplateData(template_id);
	}
	@Override
	public boolean UpdateTemplate(TemplateBean bean) {
		return this.userDaoImplementation.UpdateTemplate(bean);
	}

	@Override
	public boolean addcourse(CourseBean beans) {
		return this.userDaoImplementation.addcourse(beans);
	}
	
	@Override
	public List<CourseBean> getCourseList() {
			
		return this.userDaoImplementation.getCourseList();
	}

	@Override
	public List<CourseBean> getCourseData(int course_id) {
			// TODO Auto-generated method stub
		return this.userDaoImplementation.getCourseData(course_id);
	}

	@Override
	public boolean UpdateCourse(CourseBean bean) {
			// TODO Auto-generated method stub
		return this.userDaoImplementation.UpdateCourse(bean);
	}*/


    
}
