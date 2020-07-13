package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import sql_link.DBConnection;

public class QueryTotalRevenueByDateDao {

	// 按日期查总收入
	public Integer querytotalrevenueByAllAndDate(String date1, String date2) {
		Integer n0 = 0;
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select SUM(p_spend) from PetInfo where p_leavetime between '"
					+ date1 + "' and '" + date2 + "' and p_sign = '2'";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				n0 = (int) rs.getDouble(1);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n0;
	}

	// 按日期查宠物狗收入
	public Integer querytotalrevenueByDogAndDate(String date1, String date2) {
		Integer n1 = 0;
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select SUM(p_spend) from PetInfo where p_type='宠物狗' and p_leavetime between '"
					+ date1 + "' and '" + date2 + "' and p_sign = '2'";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				n1 = (int) rs.getDouble(1);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n1;
	}

	// 按日期查宠物猫收入
	public Integer querytotalrevenueByCatAndDate(String date1, String date2) {
		Integer n2 = 0;
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select SUM(p_spend) from PetInfo where p_type='宠物猫' and p_leavetime between '"
					+ date1 + "' and '" + date2 + "' and p_sign = '2'";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				n2 = (int) rs.getDouble(1);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n2;
	}

	// 按日期查其他宠物收入
	public Integer querytotalrevenueByOtherAndDate(String date1, String date2) {
		Integer n3 = 0;
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select SUM(p_spend) from PetInfo where p_type='其他宠物' and p_leavetime between '"
					+ date1 + "' and '" + date2 + "' and p_sign = '2'";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				n3 = (int) rs.getDouble(1);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n3;
	}
}
