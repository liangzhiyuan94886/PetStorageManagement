package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sql_link.DBConnection;

import com.Javabean.Pet_Feeder;

public class QueryFeederInfoDao {
//	public static void main(String[] args) {
//		QueryFeederInfoDao qfi = new QueryFeederInfoDao();
//		qfi.queryFeederInfo();
//	}
	public List<Pet_Feeder> queryFeederInfo() {
		List<Pet_Feeder> feeder_list = new ArrayList<Pet_Feeder>();
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from feederinfo";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Pet_Feeder eu = new Pet_Feeder();
				eu.setF_id(rs.getInt(1));
				eu.setF_number(rs.getString(2));
				eu.setF_name(rs.getString(3));
				eu.setF_sex(rs.getString(4));
				eu.setF_idcard(rs.getString(5));
				eu.setF_tel(rs.getString(6));
				eu.setF_address(rs.getString(7));
				eu.setF_notes(rs.getString(8));
				eu.setF_filename(rs.getString(9));
				feeder_list.add(eu);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feeder_list;

	}

}
