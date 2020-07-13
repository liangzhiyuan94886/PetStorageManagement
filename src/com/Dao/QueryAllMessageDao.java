package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Javabean.Pet_message;

import sql_link.DBConnection;


public class QueryAllMessageDao {
	public List<Pet_message> QueryAllMessages() {
		List<Pet_message> message = new ArrayList<Pet_message>();
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from message";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Pet_message eu = new Pet_message();
				eu.setM_id(rs.getInt(1));
				eu.setM_username(rs.getString(2));
				eu.setM_content(rs.getString(3));
				eu.setM_date(rs.getString(4));
				message.add(eu);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	
	//首页显示
	public List<Pet_message> QueryOnlyMessages() {
		List<Pet_message> message = new ArrayList<Pet_message>();
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from message where m_sign=2";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Pet_message eu = new Pet_message();
				eu.setM_id(rs.getInt(1));
				eu.setM_username(rs.getString(2));
				eu.setM_content(rs.getString(3));
				eu.setM_date(rs.getString(4));
				message.add(eu);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
