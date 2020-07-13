package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sql_link.DBConnection;

import com.Javabean.Pet_Bespoke;

public class QueryBespokeDao {
	public List<Pet_Bespoke> QueryBespoke() {
		List<Pet_Bespoke> bespoke = new ArrayList<Pet_Bespoke>();
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from bespoke where b_sign = 1";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Pet_Bespoke eu = new Pet_Bespoke();
				eu.setB_id(rs.getInt(1));
				eu.setB_userid(rs.getInt(2));
				eu.setB_username(rs.getString(3));
				eu.setB_type(rs.getString(4));
				eu.setB_pet(rs.getString(5));
				eu.setB_tel(rs.getString(6));
				eu.setB_date(rs.getString(7));
				bespoke.add(eu);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bespoke;
	}

}
