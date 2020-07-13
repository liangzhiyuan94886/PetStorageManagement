package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql_link.DBConnection;

public class UpdatePasswordDao {
	public boolean  UpdatePassword(String newuserPassword,String userName){
		boolean flag = false;
		Connection con = DBConnection.getCnnection();
		String sql = "update user set userPassword=? where userName=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newuserPassword);
			ps.setString(2, userName);
			int a = ps.executeUpdate();
			if(a>0){
				flag = true;
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;	
	}

}
