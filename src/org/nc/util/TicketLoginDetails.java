package org.nc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TicketLoginDetails {

	 public static void insertTicketingDetails(String employee_id,String employee_name,String email_address,String mobile_no)
	 {
		 Statement stmt1=null;
		    ResultSet rs=null;
		    String email_idd=null;
		    String ost_user_id=null;
		    String form_id=null;
		    Connection con=null;
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");  
			 con=DriverManager.getConnection(  
			 "jdbc:mysql://202.143.96.19/osticket?autoReconnect=true","root","Mysql@1234$#$");  
			 stmt1=con.createStatement();
			 
			 String ost_user_email="insert into ost_user_email(user_id,address,flags) values('0','"+email_address+"','0')";
				stmt1.executeUpdate(ost_user_email);
				String user_email_id="select id  from ost_user_email order by id desc limit 1";
				 rs= stmt1.executeQuery(user_email_id);
				  while(rs.next())
				  {
					  email_idd=rs.getString("id");
				   }
				System.out.println("email_idd::::::::::::::::::; "+email_idd);
				
			 String ost_user="insert into ost_user(org_id,default_email_id,status,name,created,updated) values ('0','"+email_idd+"','0','"+employee_name+"',now(),now())";
			 stmt1.executeUpdate(ost_user);
			 String getost_user="select id  from ost_user order by id desc limit 1";
			 rs= stmt1.executeQuery(getost_user);
			  while(rs.next())
			  {
				  ost_user_id=rs.getString("id");
			   }
			System.out.println("ost_user_id::::::::::::::::::; "+ost_user_id);
			       
			String ost_user_account="insert into ost_user_account(user_id,status,timezone,username,passwd,extra,registered) values ('"+ost_user_id+"','1','Asia/Kolkata','"+employee_id+"','"+employee_id+"','',now())";
			stmt1.executeUpdate(ost_user_account);
			
			String account_id="update ost_user_email set user_id='"+ost_user_id+"' where address='"+email_address+"'";
			stmt1.executeUpdate(account_id);
			
			String ost_form_query="insert into ost_form_entry(form_id,object_id,object_type,sort,created,updated) values ('1','"+ost_user_id+"','U','1',now(),now())";
			stmt1.executeUpdate(ost_form_query);
			
			String ost_form_id="select id from ost_form_entry order by id desc limit 1";
			 rs= stmt1.executeQuery(ost_form_id);
			  while(rs.next())
			  {
				  form_id=rs.getString("id");
			   }
			System.out.println("form_id::::::::::::::::::; "+form_id);
			String ost_form_value1="insert into ost_form_entry_values(entry_id,field_id,value) values ('"+form_id+"','3','"+mobile_no+"')";
			stmt1.executeUpdate(ost_form_value1);
			String ost_form_value2="insert into ost_form_entry_values(entry_id,field_id) values ('"+form_id+"','4')";
			stmt1.executeUpdate(ost_form_value2);
			String ost_form_value3="insert into ost_form_entry_values(entry_id,field_id,value) values ('"+form_id+"','36','"+employee_id+"')";
			stmt1.executeUpdate(ost_form_value3);
			
			
			
			 }catch (Exception e2) {
				 System.out.println(e2.getMessage());
				 }  
			          finally {
			        	  try {
							con.close();
							stmt1.close();
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        	 
					}
		
			
		 
		 
		 
		 
		 
		 
		 
	 }
	
	
	
	
	
}
