package org.nc.admin.DaoImplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.nc.admin.Dao.UserDao;
import org.nc.admin.beans.RequestBean;
import org.nc.admin.beans.TravelExpenseBean;
import org.nc.entitybeans.ExpenseMaster;
import org.nc.entitybeans.ExpensiveDetails;
import org.nc.entitybeans.ManagersBudget;
import org.nc.entitybeans.Request;
import org.nc.entitybeans.UserRequest;
import org.nc.entitybeans.Users;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;



public class UserDaoImplementation implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	String emailId=null;
	String emailPass= null; 
	
	ResultSet rst = null;
	PreparedStatement prest = null;
	java.sql.Connection connection = null;
	String user_id = null;

	@Override
	public boolean CreateReembersement(TravelExpenseBean bean) {
		
		javax.mail.Session mailSession = null;
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			ExpenseMaster em = new ExpenseMaster();
			em.setDepartment(bean.getDepartment());
			em.setDesignation(bean.getDesignation());
			em.setDivision(bean.getDivision());
			em.setEmployee_id(bean.getEmployee_id());
			em.setEmployee_name(bean.getEmployee_name());
			em.setManager_name(bean.getManager_name());
			em.setReason_of_travel(bean.getReason_of_travel());
			
			em.setTotal_expense_price(bean.getTotal_expense_price());
			em.setTransport_type(bean.getTransport_type());
			em.setTravelling_date_from(bean.getTravelling_date_from());
			em.setTravelling_date_to(bean.getTravelling_date_to());
			em.setTravelling_from(bean.getTravelling_from());
			em.setTravelling_to(bean.getTravelling_to());
			session.persist(em);
			
			Iterator<String> amount = bean.getAmount().iterator();
			Iterator<String> date_of_event = bean.getDate_of_event().iterator();
			Iterator<String> description = bean.getDescription().iterator();
			//Iterator<String> attachment = bean.getAttachment().iterator();
			
			
			
			while (amount.hasNext() && date_of_event.hasNext() && description.hasNext())
			{
				ExpensiveDetails ed = new ExpensiveDetails();
				ed.setAmount(amount.next());
				ed.setDate_of_event(date_of_event.next());
				ed.setDescription(description.next());
				ed.setExpense_master_id(em.getId());
				session.save(ed);
			}
			
			System.out.println("here mail sending logic");
			
			String host = "smtp.gmail.com";
			emailId = "noreply@netconnectglobal.com";
			emailPass = "gbjdefzpaqgjpmup";
			String send_email_to = "vinaykumar.k@netconnectglobal.com";
			
			System.out.println("send_emial_to:::"+send_email_to);
			
			Properties props = new Properties();
			
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", emailId);
			props.put("mail.smtp.password", emailPass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

			mailSession = javax.mail.Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(emailId, emailPass);
					}
				});

			try {
				Message message = new MimeMessage(mailSession);
				message.setFrom(new InternetAddress("" + emailId + ""));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(send_email_to));
				//message.addRecipient(RecipientType.CC, new InternetAddress("vinaykumar.k@netconnectglobal.com"));
				message.setSubject("Approval Link for "+bean.getEmployee_name()+" Reimbursement Form");
				message.setContent("<p color='black'>Dear "+bean.getManager_name()+",<br/> "
						+ "<p style='color:black'>Greetings for the Day!!!! <br/>"
						+ "<p style='color:black'>Link : <a href='http://localhost:8080/Expense_Management'>ReimbursementLinkFor_"+bean.getEmployee_name()+"'</a><br/><br/>"
						
				        + "<br />Website: www.netconnectglobal.com </p>"
				        +"</div>", "text/html");
				System.out.println("content:::"+message.getContentType());
				System.out.println("message::"+message);
				System.out.println("Content::"+message.getContent());
					
					
				Transport.send(message);
				} catch (MessagingException e) {
					e.getMessage();
				}

			
			transaction.commit();
			status1 = true;
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		}
		return status1;
		
	}

	@Override
	public List<TravelExpenseBean> getList(int master_id) {
		List<TravelExpenseBean> expense_list=null;
		List<ExpensiveDetails> list= null;
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		System.out.println("welcome to the expense detailssss view ");
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query query6=session.createQuery("from ExpensiveDetails where expense_master_id="+master_id+"");
			list=query6.list();
			expense_list = new ArrayList<TravelExpenseBean>();
			for(Iterator it2 = list.iterator(); it2.hasNext();)
			{
				ExpensiveDetails ex = (ExpensiveDetails) it2.next();
				TravelExpenseBean bean = new TravelExpenseBean();
				bean.setId(ex.getId());
				bean.setSingle_date_of_event(ex.getDate_of_event());
				bean.setSingle_amount(ex.getAmount());
				bean.setSingle_description(ex.getDescription());
				
				
				expense_list.add(bean);
			}
			
			
			
			
		}catch(Exception ex) {
		   ex.printStackTrace();
		}
		
		
		return expense_list;
	}

	@Override
	public List<TravelExpenseBean> getListofMasterData(int master_id) {
		List<TravelExpenseBean> master_list=null;
		List<ExpenseMaster> list= null;
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query query8=session.createQuery("from ExpenseMaster where id="+master_id+"");
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
				bean.setTravelling_from(ex.getTravelling_to());
				bean.setTravelling_to(ex.getTravelling_to());
				bean.setDesignation(ex.getDesignation());
				bean.setDivision(ex.getDivision());
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
	public boolean Approve_Reermberse(TravelExpenseBean bean) {
		Transaction transaction=null;
		Session session=null;
		boolean status=false;
		List<ExpenseMaster> list1= null;
		try{
			
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Query query1=session.createQuery("from ExpenseMaster where id="+bean.getId()+"");
			list1=query1.list();
			for(Iterator it2 = list1.iterator(); it2.hasNext();)
			{
				ExpenseMaster org = (ExpenseMaster) it2.next();
					org.setManager_approval("1");
					session.update(org);	
			}
			
			transaction.commit();
			status=true;
			
		}
		catch(Exception e)
		{session.getTransaction().rollback();session.clear();session.close();
		e.getMessage();}finally{session.clear();session.close();}
		
		return status;
	}

	@Override
	public boolean Reject_Reermberse(TravelExpenseBean bean) {
		Transaction transaction=null;
		Session session=null;
		boolean status=false;
		List<ExpenseMaster> list1= null;
		try{
			
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Query query1=session.createQuery("from ExpenseMaster where id="+bean.getId()+"");
			list1=query1.list();
			for(Iterator it2 = list1.iterator(); it2.hasNext();)
			{
				ExpenseMaster org = (ExpenseMaster) it2.next();
					org.setManager_approval("2");
					session.update(org);	
			}
			
			transaction.commit();
			System.out.println("updated");
			status=true;
			
		}
		catch(Exception e)
		{session.getTransaction().rollback();session.clear();session.close();
		e.getMessage();}finally{session.clear();session.close();}
		
		return status;
	}


	//aks
	@Override
	public boolean requestform(UserRequest bean) {
		
		javax.mail.Session mailSession = null;
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		List<Users> list1= null;
		Users user=null;
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			
			Query query1=session.createQuery("from Users where user_id="+bean.getUser_id()+"");
			list1=query1.list();
			for(Iterator it2 = list1.iterator(); it2.hasNext();)
			{
				user = (Users) it2.next();
	
			}
			
			session.persist(bean);
			
			System.out.println("here mail sending logic");
			
			String host = "smtp.gmail.com";
			emailId = "noreply@netconnectglobal.com";
			emailPass = "gbjdefzpaqgjpmup";
			String send_email_to = "vinaykumar.k@netconnectglobal.com";
			
			//System.out.println("send_emial_to:::"+send_email_to);
			
			Properties props = new Properties();
			
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", emailId);
			props.put("mail.smtp.password", emailPass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

			mailSession = javax.mail.Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(emailId, emailPass);
					}
				});

			try {
				Message message = new MimeMessage(mailSession);
				message.setFrom(new InternetAddress("" + emailId + ""));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(send_email_to));
				message.setSubject("Approval Link for Reimbursement Form");
				message.setContent("<p color='black'>Dear "+user.getManager_name()+",<br/> "
						+ "<p style='color:black'>Greetings for the Day!!!! <br/>"
						+ "<p style='color:black'><em>Link : <a href='http://localhost:8080/Expense_Management>User Reimbursement Request </a><br/>"
						/*+ "<p style='color:black'>Link : <button href='http://localhost:8080/Expense_Management/approvalrequest?id="+em.getId()+"'>Approve</button><br/><br/>"
								+ "<p style='color:black'>Link :<button href='http://localhost:8080/Expense_Management/rejectrequest?id="+em.getId()+"'>Reject</button><br/><br/>"
						*/
				        + "<br />Website: www.netconnectglobal.com </p>"
				        +"</div>", "text/html");
				System.out.println("content:::"+message.getContentType());
				System.out.println("message::"+message);
				System.out.println("Content::"+message.getContent());
					
					
				Transport.send(message);
				} catch (MessagingException e) {
					e.getMessage();
				}

			
			transaction.commit();
			status1 = true;
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		}
		return status1;
		
		
		
	}

	//aks
	/*public boolean approvalRequest(int request_id,int newBudgetInHand) {
		Transaction transaction=null;
		Session session=null;
		boolean status=false;
		List<UserRequest> list1= null;
		int manager_id=0;
		try{

		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query query1=session.createQuery("from UserRequest where id="+request_id+"");
		list1=query1.list();
		for(Iterator it2 = list1.iterator(); it2.hasNext();)
		{
			UserRequest org = (UserRequest) it2.next();
			
			org.setManager_approval(1);
			manager_id = org.getManager_id_fk();
		
		session.update(org);	
		}

		transaction.commit();
		status=true;

		}
	catch(Exception e)
		{session.getTransaction().rollback();session.clear();session.close();
		e.getMessage();}finally{session.clear();session.close();}
		
		
		try{

			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Query query1=session.createQuery("from ManagersBudget where id="+manager_id+"");
			list1=query1.list();
			for(Iterator it2 = list1.iterator(); it2.hasNext();)
			{
				ManagersBudget org = (ManagersBudget) it2.next();
				org.setBudget_in_hand(newBudgetInHand);
			
			session.update(org);	
			}

			transaction.commit();
			status=true;

			}
		catch(Exception e)
		{session.getTransaction().rollback();session.clear();session.close();
		e.getMessage();}finally{session.clear();session.close();}

		return status;
	}*/

	/*@Override
	public boolean CreateCompany(SuperCompanyBean bean) {
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			SuperCompany sc = new SuperCompany();
			sc.setAdmin_contact_no(bean.getAdmin_contact_no());
			sc.setAdmin_email(bean.getAdmin_email());
			sc.setAdmin_name(bean.getAdmin_name());
			sc.setUser(bean.getUser());
			sc.setNo_of_users(bean.getNo_of_users());
			sc.setEnd_date(bean.getEnd_date());
			sc.setStart_date(bean.getStart_date());
			sc.setCompany_address(bean.getCompany_address());
			sc.setCompany_admin(bean.getCompany_admin());
			sc.setCompany_default_email(bean.getCompany_default_email());
			sc.setCompany_name(bean.getCompany_name());
			sc.setCompany_website(bean.getCompany_website());
			sc.setTemplate(bean.getTemplate());
			sc.setFilename(bean.getFilename());
			sc.setAccount_type(bean.getAccount_type());
			session.save(sc);
			transaction.commit();
			status1 = true;
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		}
		return status1;
	}

	@Override
	public List<SuperCompanyBean> getCompanyList() {
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		List<SuperCompanyBean> company_list= null;
		List<SuperCompany> list= null;
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Query query1=session.createQuery("from SuperCompany order by id desc");
			list=query1.list();
			company_list = new ArrayList<SuperCompanyBean>();
			for(Iterator it2 = list.iterator(); it2.hasNext();)
			{
				SuperCompany sc = (SuperCompany) it2.next();
				SuperCompanyBean bean = new SuperCompanyBean();
				bean.setId(sc.getId());
			    bean.setCompany_name(sc.getCompany_name());
			    bean.setNo_of_users(sc.getNo_of_users());
			    bean.setStart_date(sc.getStart_date());
			    bean.setEnd_date(sc.getEnd_date());
			    company_list.add(bean);
			}
			transaction.commit();
			
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		}
		return company_list;
	}

	@Override
	public List<SuperCompanyBean> getCompanyData(int id) {
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		List<SuperCompanyBean> company_list= null;
		List<SuperCompany> list= null;
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Query query1=session.createQuery("from SuperCompany where id="+id+" order by id desc");
			list=query1.list();
			company_list = new ArrayList<SuperCompanyBean>();
			for(Iterator it2 = list.iterator(); it2.hasNext();)
			{
				SuperCompany sc = (SuperCompany) it2.next();
				SuperCompanyBean bean = new SuperCompanyBean();
				bean.setId(sc.getId());
			    bean.setCompany_name(sc.getCompany_name());
			    bean.setNo_of_users(sc.getNo_of_users());
			    bean.setStart_date(sc.getStart_date());
			    bean.setEnd_date(sc.getEnd_date());
			    bean.setAdmin_contact_no(sc.getAdmin_contact_no());
			    bean.setAdmin_email(sc.getAdmin_email());
			    bean.setAdmin_name(sc.getAdmin_name());
			    bean.setCompany_address(sc.getCompany_address());
			    bean.setCompany_default_email(sc.getCompany_default_email());
			    bean.setCompany_website(sc.getCompany_website());
			    bean.setIc_committe(sc.getIc_committe());
			    bean.setUser(sc.getUser());
			    bean.setCompany_admin(sc.getCompany_admin());
			    bean.setTemplate(sc.getTemplate());
			    bean.setAccount_type(sc.getAccount_type());
			    company_list.add(bean);
			}
			transaction.commit();
			
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		}
		return company_list;
	}

	@Override
	public boolean UpdateCompany(SuperCompanyBean bean) {
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			SuperCompany sc = (SuperCompany)session.get(SuperCompany.class,bean.getId());
			System.out.println("updating");
			sc.setAdmin_contact_no(bean.getAdmin_contact_no());
			sc.setAdmin_email(bean.getAdmin_email());
			sc.setAdmin_name(bean.getAdmin_name());
			sc.setUser(bean.getUser());
			sc.setNo_of_users(bean.getNo_of_users());
			sc.setEnd_date(bean.getEnd_date());
			sc.setStart_date(bean.getStart_date());
			sc.setCompany_address(bean.getCompany_address());
			sc.setCompany_admin(bean.getCompany_admin());
			sc.setCompany_default_email(bean.getCompany_default_email());
			sc.setCompany_name(bean.getCompany_name());
			sc.setCompany_website(bean.getCompany_website());
			sc.setTemplate(bean.getTemplate());
			
			sc.setAccount_type(bean.getAccount_type());
			session.update(sc);
			
			transaction.commit();
			status1 = true;
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		}
		return status1;
		
	}

	@Override
	public boolean addtemplate(TemplateBean beans) {
		Transaction transaction = null;
		Session session = null;
		boolean status = false;
		try {
			
			System.out.println("welcome to dao1");
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Template ntbean=new Template();
		  ntbean.setTemplate_id(beans.getTemplate_id());
		  ntbean.setTemplate_name(beans.getTemplate_name());
		  ntbean.setSummary(beans.getSummary());
		
		
		session.save(ntbean);
		transaction.commit();
		status = true;
	} catch (Exception e) {
		session.getTransaction().rollback();
		session.clear();
		session.close();
		e.getMessage();
	} finally {
		session.clear();
		session.close();
	}
	return status;
		
		
	}

	@Override
	public List<TemplateBean> getTemplateList() {
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		List<TemplateBean> template_list= null;
		List<Template> list= null;
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Query query1=session.createQuery("from Template order by id desc");
			list=query1.list();
			template_list = new ArrayList<TemplateBean>();
			for(Iterator it2 = list.iterator(); it2.hasNext();)
			{
				Template sc = (Template) it2.next();
				TemplateBean bean = new TemplateBean();
				bean.setTemplate_id(sc.getTemplate_id());
				bean.setTemplate_name(sc.getTemplate_name());
				bean.setSummary(sc.getSummary());
				template_list.add(bean);
			}
			transaction.commit();
			
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		}
		return template_list;
	}

	@Override
	public List<TemplateBean> getTemplateData(int template_id) {
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		List<TemplateBean> template_list= null;
		List<Template> list= null;
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Query query1=session.createQuery("from Template where template_id="+template_id+" order by template_id desc");
			list=query1.list();
			template_list = new ArrayList<TemplateBean>();
			for(Iterator it2 = list.iterator(); it2.hasNext();)
			{
				Template sc = (Template) it2.next();
				TemplateBean bean = new TemplateBean();
			bean.setTemplate_id(sc.getTemplate_id());
			bean.setTemplate_name(sc.getTemplate_name());
			bean.setSummary(sc.getSummary());
			   
			template_list.add(bean);
			}
			transaction.commit();
			
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		}
		return template_list;
	}

	@Override
	public boolean UpdateTemplate(TemplateBean bean) {
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Template sc = (Template)session.get(Template.class,bean.getTemplate_id());
			System.out.println("updating");
			
			sc.setTemplate_name(bean.getTemplate_name());
		sc.setSummary(bean.getSummary());
			
			session.update(sc);
			
			transaction.commit();
			status1 = true;
		} catch (Exception e) {
			e.getMessage();
			transaction.rollback();
			session.clear();
			session.close();
		}
		return status1;
	}

	@Override
	public boolean addcourse(CourseBean beans) {
		Transaction transaction = null;
		Session session = null;
		boolean status = false;
		try {
			
			System.out.println("welcome to dao1");
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Course ntbean=new Course();
		ntbean.setCourse_id(beans.getCourse_id());
		ntbean.setCoursename(beans.getCoursename());
		ntbean.setBanner(beans.getBanner());
		ntbean.setSummery(beans.getSummery());
		session.save(ntbean);
		transaction.commit();
		status = true;
	} catch (Exception e) {
		session.getTransaction().rollback();
		session.clear();
		session.close();
		e.getMessage();
	} finally {
		session.clear();
		session.close();
	}
	return status;
	}

	@Override 
	public List<CourseBean> getCourseList() {
			
			Session session = null;
			Transaction transaction = null;
			boolean status1 = false;
			List<CourseBean> course_list= null;
			List<Course> list= null;
			try {

				session = sessionFactory.getCurrentSession();
				transaction = session.beginTransaction();
				Query query1=session.createQuery("from Course order by course_id desc");
				list=query1.list();
				course_list = new ArrayList<CourseBean>();
				for(Iterator it2 = list.iterator(); it2.hasNext();)
				{
					Course cs = (Course) it2.next();
					CourseBean bean = new CourseBean();
					
					bean.setCourse_id(cs.getCourse_id());
					bean.setCoursename(cs.getCoursename());
					bean.setBanner(cs.getBanner());
					bean.setSummery(cs.getSummery());
					
					
					
					course_list.add(bean);
				}
				transaction.commit();
				
			} catch (Exception e) {
				e.getMessage();
				transaction.rollback();
				session.clear();
				session.close();
			}
			return course_list;
		}

	@Override
	public List<CourseBean> getCourseData(int course_id) {
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
		List<CourseBean> course_list= null;
		List<Course> list= null;
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Query query1=session.createQuery("from Course where course_id="+course_id+"");
	    	list=query1.list();
			course_list = new ArrayList<CourseBean>();
			for(Iterator it2 = list.iterator(); it2.hasNext();)
			{
				Course cs = (Course) it2.next();
				CourseBean bean = new CourseBean();
				bean.setCourse_id(cs.getCourse_id());
				bean.setCoursename(cs.getCoursename());
				bean.setBanner(cs.getBanner());
				bean.setSummery(cs.getSummery());
				   
				course_list.add(bean);
				}
				transaction.commit();
				
			} catch (Exception e) {
				e.getMessage();
				transaction.rollback();
				session.clear();
				session.close();
			}
			return course_list;
		}

	@Override
	public boolean UpdateCourse(CourseBean bean) {
		Session session = null;
		Transaction transaction = null;
		boolean status1 = false;
			
		try {

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Course cs = (Course)session.get(Course.class,bean.getCourse_id());
			System.out.println("updating");
				
			cs.setCoursename(bean.getCoursename());
			cs.setBanner(bean.getBanner());
			cs.setSummery(bean.getSummery());
				
			session.update(cs);
				
			transaction.commit();
			status1 = true;
			} catch (Exception e) {
				e.getMessage();
				transaction.rollback();
				session.clear();
				session.close();
			}
			return status1;
		}
		
*/
	

	//aks
		public boolean approvalRequest(int request_id,int newBudgetInHand) {
			Transaction transaction=null;
			Session session=null;
			boolean status=false;
			List<UserRequest> list1= null;
			List<ManagersBudget> list2= null;
			int manager_id=0;
			try{

			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Query query1=session.createQuery("from UserRequest where id="+request_id+"");
			list1=query1.list();
			for(Iterator it2 = list1.iterator(); it2.hasNext();)
			{
				UserRequest org = (UserRequest) it2.next();
				if(newBudgetInHand == 0 ) {
				org.setManager_approval(2);
				
				}
				else {
					org.setManager_approval(1);
					manager_id = org.getManager_id_fk();
				}
			
			session.update(org);	
			}
		
			transaction.commit();
			if(newBudgetInHand != 0)
			status = updateLeftBudget(manager_id,newBudgetInHand);
			status = true;

			}
		catch(Exception e)
			{session.getTransaction().rollback();session.clear();session.close();
			e.getMessage();}finally{session.clear();session.close();}
		

			return status;
		}
		
		//aks
			public boolean updateLeftBudget(int manager_id,int newBudgetInHand) {
				Transaction transaction=null;
				Session session=null;
				boolean status=false;
				List<UserRequest> list1= null;
				List<ManagersBudget> list2= null;
				
				try{

				session=sessionFactory.openSession();
				transaction=session.beginTransaction();
				
				
				Query query2=session.createQuery("from ManagersBudget where id="+manager_id+"");
				list2=query2.list();
				ManagersBudget managersBudget1 = new ManagersBudget();
				for(Iterator it2 = list2.iterator(); it2.hasNext();)
				{
					
					ManagersBudget managersBudget = (ManagersBudget) it2.next();
					managersBudget.setBudget_in_hand(newBudgetInHand);
				
				session.update(managersBudget);	
				}
		
				transaction.commit();
				status=true;

				}
			catch(Exception e)
				{session.getTransaction().rollback();session.clear();session.close();
				e.getMessage();}finally{session.clear();session.close();}
			

				return status;
			}
	

}
