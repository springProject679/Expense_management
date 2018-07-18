package org.nc.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeIdGenerator implements IdentifierGenerator {


public Serializable generate(SessionImplementor session, Object object)
        throws HibernateException {
		Connection connection = session.connection();
    try {
    	String code=null;
        PreparedStatement ps = connection.prepareStatement("SELECT * from nc_employee");
        ResultSet rs = ps.executeQuery();
       if (rs.last())
	       {
	         String eid =rs.getString(1);
	         System.out.println(eid);
	         int tmp = Integer.parseInt(eid);
		         tmp += 1;
		         if (tmp < 10)
		         {
		        	 code = "EMP00000" + tmp;
		         } else if ((tmp >= 10) && (tmp < 100))
		         {
		        	 code = "EMP0000" + tmp;
		         }
		       }
		       else {
		    	   code = "EMP000001";
		       }
        return code;} catch (SQLException e) {       
        e.printStackTrace();} return null;
}



}
