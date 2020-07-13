package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql_link.DBConnection;

public class UpdatePetInformationDao {
	public boolean UpdatePetInformation(Double id,String name,String type,String pets,String color,Double weight,Double age,String owner){
		boolean flag = false;
		Connection con = DBConnection.getCnnection();
		String sql = "update petinformation set m_name=?,m_type=?,m_pets=?,m_color=?,m_weight=?,m_age=?,m_owner=? where m_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, type);
			ps.setString(3, pets);
			ps.setString(4, color);
			ps.setDouble(5, weight);
			ps.setDouble(6, age);
			ps.setString(7, owner);
			ps.setDouble(8, id);
			int a = ps.executeUpdate();
			if(a>0){
				flag=true;
			}
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
