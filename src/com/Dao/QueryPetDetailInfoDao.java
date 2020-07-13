package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sql_link.DBConnection;

import com.Javabean.Pet_Info;

public class QueryPetDetailInfoDao {
	public Pet_Info QueryPetDetailInfo(Integer p_id) {
		Pet_Info eu = null;
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from petinfo where p_id=?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setInt(1, p_id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				eu = new Pet_Info();
				eu.setP_id(rs.getInt(1));
				eu.setP_user(rs.getString(2));
				eu.setP_tel(rs.getString(3));
				eu.setP_type(rs.getString(4));
				eu.setP_pet(rs.getString(5));
				eu.setP_combo(rs.getString(6));
				eu.setP_price1(rs.getDouble(7));
				eu.setP_other(rs.getString(8));
				eu.setP_price2(rs.getDouble(9));
				eu.setP_notes(rs.getString(10));
				eu.setP_time(rs.getString(11));
				eu.setP_filename(rs.getString(17));
				eu.setP_operator(rs.getString(18));
			}
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eu;

	}

}
