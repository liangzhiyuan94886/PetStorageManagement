package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sql_link.DBConnection;
import com.Javabean.Pet_Feeder;

public class QueryFeederInfoByIdDao {
	public Pet_Feeder QueryFeederInfoById(Integer f_id) {
		Pet_Feeder eu = null;
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from feederinfo where f_id=?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setInt(1, f_id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				eu = new Pet_Feeder();
				eu.setF_id(rs.getInt(1));
				eu.setF_number(rs.getString(2));
				eu.setF_name(rs.getString(3));
				eu.setF_sex(rs.getString(4));
				eu.setF_idcard(rs.getString(5));
				eu.setF_tel(rs.getString(6));
				eu.setF_address(rs.getString(7));
				eu.setF_notes(rs.getString(8));
				eu.setF_filename(rs.getString(9));
			}
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eu;

	}

}
