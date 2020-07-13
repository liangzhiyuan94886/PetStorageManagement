package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Javabean.Pet_Bespoke;

import sql_link.DBConnection;



public class QueryBespokeByIdDao {
	public Pet_Bespoke QueryBespokeById(Integer id){
		Pet_Bespoke eu =null;
		try{
			Connection con = DBConnection.getCnnection();
			String sql = "select * from bespoke where b_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				eu = new Pet_Bespoke();
				eu.setB_id(rs.getInt(1));
				eu.setB_userid(rs.getInt(2));
				eu.setB_username(rs.getString(3));
				eu.setB_type(rs.getString(4));
				eu.setB_pet(rs.getString(5));
				eu.setB_tel(rs.getString(6));
				eu.setB_date(rs.getString(7));
			}
			con.close();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eu;
	}

}
