package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sql_link.DBConnection;

import com.Javabean.Pet_Admin;

public class QueryMyInfoDao {
	public Pet_Admin QueryMyInfoByA_Admin(String a_admin) {
		Pet_Admin eu = null;
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from admin where a_admin=?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, a_admin);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				eu = new Pet_Admin();
				eu.setA_id(rs.getInt(1));
				eu.setA_number(rs.getString(4));
				eu.setA_name(rs.getString(5));
				eu.setA_sex(rs.getString(6));
				eu.setA_idcard(rs.getString(7));
				eu.setA_tel(rs.getString(8));
				eu.setA_address(rs.getString(9));
				eu.setA_notes(rs.getString(10));
				eu.setA_filename(rs.getString(11));
			}
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eu;

	}

}
