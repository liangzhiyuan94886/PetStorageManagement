package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql_link.DBConnection;

public class UpdateUserInfoDao {
	//qu static...
	public  boolean  UpdateUserInfo(String mail,String tel,String userName){
		boolean flag = false;
		Connection con = DBConnection.getCnnection();
		String sql = "update user set mail=?,tel=? where userName=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mail);
			ps.setString(2, tel);
			ps.setString(3, userName);
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
