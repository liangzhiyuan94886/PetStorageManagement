package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql_link.DBConnection;

public class UpdateMyPasswordDao {
	public boolean  UpdateMyPassword(String newadminPassword,String adminname){
		boolean flag = false;
		Connection con = DBConnection.getCnnection();
		String sql = "update admin set a_password=? where a_admin=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newadminPassword);
			ps.setString(2, adminname);
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
