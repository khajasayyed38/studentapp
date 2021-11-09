package com.mini_project.model;
import java.sql.*;
public class ClassDAOImpl implements ClassDAO {
	
	private Connection con;
	private Statement stmnt;
	
	
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_demo_practise", "root", "test");
			stmnt=con.createStatement();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean verifyLoginCredentials(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public void newRegistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet getAllregistrations() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void deleteRegistration(String email) {
		try {
			stmnt.executeUpdate("delete from registration where emailid='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void updateMobileNumber(String email, String mobile) {
		try {
			stmnt.executeUpdate("update registration set mobile='"+mobile+"' where emailid='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
