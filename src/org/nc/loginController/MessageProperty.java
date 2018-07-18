package org.nc.loginController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.nc.entitybeans.Users;
import org.springframework.beans.factory.annotation.Autowired;
public class MessageProperty {


	
	private static final Logger logger = Logger
			.getLogger(MessageProperty.class);
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public String getMessage(String property) {        	
    	Properties prop = new Properties();
    	String value = "";         
    	try {        
    		prop.load(this.getClass().getResourceAsStream("/message.properties"));
    		value = prop.getProperty(property).toString();
     
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	}     	
        return value;
    }
    
   
   public String getSessionUserId(String user_name)
   {
	   String userid=null;
	   Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Users.class);	
			criteria.add(Restrictions.eq("username", user_name));
			Users employee = (Users) criteria.uniqueResult();
			userid=employee.getCustom_user_id();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			session.getTransaction().rollback();
			session.close();
		} finally {
			session.clear();
			session.close();
			
		}
		System.out.println("Session is set :: "+userid);
		return userid;
   }
   
   public String getSessionRoleNew(String user_name)
   {
	   String userid=null;
	   Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Users.class);	
			criteria.add(Restrictions.eq("username", user_name));
			Users employee = (Users) criteria.uniqueResult();
			userid=employee.getRoleNew();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			session.getTransaction().rollback();
			session.close();
		} finally {
			session.clear();
			session.close();
			
		}
		System.out.println("Session is set :: "+userid);
		return userid;
   }
   
   
  

}
