package org.nc.admin.Service;

import java.util.List;

import org.nc.admin.beans.CourseBean;
import org.nc.admin.beans.RequestBean;
import org.nc.admin.beans.SuperCompanyBean;
import org.nc.admin.beans.TemplateBean;
import org.nc.admin.beans.TravelExpenseBean;
import org.nc.entitybeans.UserRequest;



public interface UserService {

	public boolean CreateReembersement(TravelExpenseBean bean);
/*
	public boolean CreateCompany(SuperCompanyBean bean);

	public List<SuperCompanyBean> getCompanyList();

	public List<SuperCompanyBean> getCompanyData(int id);

	public boolean UpdateCompany(SuperCompanyBean bean);

	public List<TemplateBean> getTemplateList();

	public boolean addcourse(CourseBean beans);

	public boolean UpdateTemplate(TemplateBean bean);

	public List<TemplateBean> getTemplateData(int template_id);

	public boolean addtemplate(TemplateBean beans);

	public List<CourseBean> getCourseList();

	public List<CourseBean> getCourseData(int course_id);

	public boolean UpdateCourse(CourseBean bean);*/

	public List<TravelExpenseBean> getList(int master_id);

	public List<TravelExpenseBean> getListofMasterData(int master_id);

	public boolean Approve_Reermberse(TravelExpenseBean bean);

	public boolean Reject_Reermberse(TravelExpenseBean bean);

	public boolean requestform(UserRequest bean);

	public boolean approvalRequest(int id,int newBudgetInHand);

	
}
