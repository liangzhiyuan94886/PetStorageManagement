package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Javabean.Pet_Admin;

import sql_link.DBConnection;

public class QueryAccountInfoByIdDao {
	public Pet_Admin QueryAccountInfoById(Integer id){
		Pet_Admin eu =null;
		try{
			Connection con = DBConnection.getCnnection();
			String sql = "select * from admin where a_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				eu = new Pet_Admin();
				eu.setA_id(rs.getInt(1));
				eu.setA_admin(rs.getString(2));
				eu.setA_password(rs.getString(3));
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
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eu;
	}

}
