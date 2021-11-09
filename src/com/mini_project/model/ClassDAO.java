package com.mini_project.model;

import java.sql.ResultSet;

public interface ClassDAO {
	public void connectDB();
	public boolean verifyLoginCredentials(String email,String password);
	public void newRegistration(String name, String city, String email, String mobile);
	ResultSet getAllregistrations();
	public void deleteRegistration(String email);
	public void updateMobileNumber(String email, String mobile);

}
