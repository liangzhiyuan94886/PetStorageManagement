package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sql_link.DBConnection;

import com.Javabean.Pet_Admin;
//不包括账号密码，普通管理员使用
public class QueryAdminInfoDao {
	public List<Pet_Admin> queryAdminInfo() {
		List<Pet_Admin> admin_list = new ArrayList<Pet_Admin>();
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from admin";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Pet_Admin eu = new Pet_Admin();
		//仅查看不需要id		eu.setA_id(rs.getInt(1));
				eu.setA_number(rs.getString(4));
				eu.setA_name(rs.getString(5));
				eu.setA_sex(rs.getString(6));
				eu.setA_idcard(rs.getString(7));
				eu.setA_tel(rs.getString(8));
				eu.setA_address(rs.getString(9));
				eu.setA_notes(rs.getString(10));
				eu.setA_filename(rs.getString(11));
				admin_list.add(eu);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin_list;

	}
	
//查询包括账号密码
	public List<Pet_Admin> QueryAccountInfo() {
		List<Pet_Admin> admin_list = new ArrayList<Pet_Admin>();
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from admin where a_id not in(1);" ;
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Pet_Admin eu = new Pet_Admin();
				eu.setA_id(rs.getInt(1));
				eu.setA_admin(rs.getString(2));
				eu.setA_password(rs.getString(3));
				eu.setA_number(rs.getString(4));
				eu.setA_name(rs.getString(5));
				eu.setA_sex(rs.getString(6));
				eu.setA_idcard(rs.getString(7));
				eu.setA_tel(rs.getString(8));
				eu.setA_address(rs.getString(9));
				eu.setA_notes(rs.getString(10));
				eu.setA_filename(rs.getString(11));
				admin_list.add(eu);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin_list;
	}
}
