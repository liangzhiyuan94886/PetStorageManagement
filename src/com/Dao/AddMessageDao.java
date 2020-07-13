package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import sql_link.DBConnection;
//进管理员可见存1
public class AddMessageDao {
	public boolean AddMessageByone(String username,String content,String date,String sign){
		boolean flag = false;
		try{
			Connection conn = DBConnection.getCnnection();
			String sql = "insert into message (m_username,m_content,m_date,m_sign) values(?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,content);
			ps.setString(3,date);
			ps.setString(4,sign);
			int n = ps.executeUpdate();
			if (n > 0) {
				flag = true;
		}
			conn.close();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

//所有人可见存2	
	public boolean AddMessageBytwo(String username,String content,String date,Integer sign2){
		boolean flag = false;
		try{
			Connection conn = DBConnection.getCnnection();
			String sql = "insert into message (m_username,m_content,m_date,m_sign) values(?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,content);
			ps.setString(3,date);
			ps.setInt(4,sign2);
			int n = ps.executeUpdate();
			if (n > 0) {
				flag = true;
		}
			conn.close();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
