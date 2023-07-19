package com.feereport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.feereport.bean.ContactBean;

public class ContactDAO {

public static int save(ContactBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("insert into contact(name,email,message) values(?,?,?)");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getMessage());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}

}
