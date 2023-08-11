package com.regapp_model;

import java.sql.*;

public class DOAService implements DAOService {

	private Connection con;
	private Statement stmnt;
	@Override
	public boolean verfifyCredentials(String email, String password) {
		try
		{
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"'and password='"+password+"'");
			return result.next();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRegistration(String name, String phone_no, String email, String address) {
		try
		{
			
			stmnt.executeUpdate("insert into registers values('"+name+"', '"+email+"', '"+phone_no+"', '"+address+"')");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void ConnectDB()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsql", "root", "test");
			stmnt = con.createStatement();
			System.out.println("Database Connected");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet getAllReg()
	{
		try
		{
			ResultSet result = stmnt.executeQuery("select * from registers");
			return result;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void DeleteByEmail(String email)
	{
		try {
			stmnt.executeUpdate("Delete from registers where email='"+email+"'");
			System.out.println(email);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(String name, String email, String phone_no, String address)
	{
		try
		{
			stmnt.executeUpdate("update registers Set name='"+name+"', phone_no='"+phone_no+"', address='"+address+"' where email='"+email+"'");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
