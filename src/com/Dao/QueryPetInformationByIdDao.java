package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sql_link.DBConnection;
import com.Javabean.Pet_Information;

public class QueryPetInformationByIdDao {
	public Pet_Information QueryById(Integer id){
		Pet_Information eu =null;
		try{
			Connection con = DBConnection.getCnnection();
			String sql = "select * from petinformation where m_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				eu = new Pet_Information();
				eu.setM_id(rs.getInt(1));
				eu.setM_name(rs.getString(2));
				eu.setM_type(rs.getString(3));
				eu.setM_pets(rs.getString(4));
				eu.setM_color(rs.getString(5));
				eu.setM_weight(rs.getDouble(6));
				eu.setM_age(rs.getDouble(7));
				eu.setM_owner(rs.getString(8));
			}
			con.close();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eu;
	}

}
