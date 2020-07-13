package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import sql_link.DBConnection;

public class AdminLoginDao {
	public static boolean MyLoginCheck (String adminname,String adminpw) {
		boolean flag=false;
		Connection conn = DBConnection.getCnnection();
		String sql = "select * from admin where a_admin='"+adminname+"' and a_password='"+adminpw+"' ";
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

}
