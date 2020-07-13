package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sql_link.DBConnection;

import com.Javabean.Pet_Info;

public class QueryCompletedOrderDao {
	public List<Pet_Info> QueryCompletedOrder() {
		List<Pet_Info> history = new ArrayList<Pet_Info>();
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from PetInfo where p_sign = '2'";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Pet_Info eu = new Pet_Info();
				eu.setP_id(rs.getInt(1));
				eu.setP_user(rs.getString(2));
				eu.setP_tel(rs.getString(3));
				eu.setP_type(rs.getString(4));
				eu.setP_pet(rs.getString(5));
				eu.setP_combo(rs.getString(6));
				eu.setP_price1(rs.getDouble(7));
				eu.setP_other(rs.getString(8));
				eu.setP_price2(rs.getDouble(9));
				eu.setP_time(rs.getString(11));
				eu.setP_leavetime(rs.getString(12));
				eu.setP_day(rs.getInt(13));
				eu.setP_hours(rs.getInt(14));
				eu.setP_spend(rs.getDouble(15));
				eu.setP_operator(rs.getString(18));
				history.add(eu);
			}
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return history;

	}

}
