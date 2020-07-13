package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Javabean.Pet_User;

import sql_link.DBConnection;

public class UserLoginDao {
	public static boolean MyLoginCheck (String username,String userpw) {
		boolean flag=false;
		Connection conn = DBConnection.getCnnection();
		String sql = "select * from user where userName='"+username+"' and userPassword='"+userpw+"' ";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				flag = true;
			}
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
	}

	
	//获取用户ID
	public Pet_User  QueryUserID(String userName){
		Connection con = DBConnection.getCnnection();
		String sql = "select u_id from user where userName=?";
		Pet_User user = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userName);
			ResultSet rs = ps.executeQuery();
			rs.next();
			user = new Pet_User();
			user.setU_id(rs.getInt(1));
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
}
