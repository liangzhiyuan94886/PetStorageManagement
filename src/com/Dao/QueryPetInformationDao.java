package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sql_link.DBConnection;

import com.Javabean.Pet_Information;

public class QueryPetInformationDao {
	public List<Pet_Information> queryPetInformation() {
		List<Pet_Information> list = new ArrayList<Pet_Information>();
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from petinformation ";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Pet_Information eu = new Pet_Information();
				eu.setM_id(rs.getInt(1));
				eu.setM_name(rs.getString(2));
				eu.setM_type(rs.getString(3));
				eu.setM_pets(rs.getString(4));
				eu.setM_color(rs.getString(5));
				eu.setM_weight(rs.getDouble(6));
				eu.setM_age(rs.getDouble(7));
				eu.setM_owner(rs.getString(8));
				list.add(eu);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

}
