package com.regapp_model;
import java.sql.ResultSet;
public interface DAOService {
	public void ConnectDB();
	
	public boolean verfifyCredentials(String email, String password);
	
	public void saveRegistration(String name, String phone_no, String email, String address);
	
	public ResultSet getAllReg();

	public void DeleteByEmail(String email);
	public void update(String name , String email, String phone_no, String address);
}
