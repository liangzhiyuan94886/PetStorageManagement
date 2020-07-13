package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import sql_link.DBConnection;

public class AddPetInformationDao {
	public boolean addpetinformation(String name,String type,String pets,String color,Double weight,Double age,String owner){
		boolean flag = false;
		try{
			Connection conn = DBConnection.getCnnection();
	//		System.out.println("数据库连接成功");
			String sql = "insert into petinformation (m_name,m_type,m_pets,m_color,m_weight,m_age,m_owner) values(?,?,?,?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,type);
			ps.setString(3,pets);
			ps.setString(4,color);
			ps.setDouble(5,weight);
			ps.setDouble(6,age);
			ps.setString(7,owner);
			int n = ps.executeUpdate();
			if (n > 0) {
				flag = true;
		}
			conn.close();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
