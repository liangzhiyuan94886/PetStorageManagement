package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import sql_link.DBConnection;

public class AddBespokeDao {
	public boolean AddBespoke(Integer id,String name,String type,String pet,String tel,String date,Integer b_sign){
		boolean flag = false;
		try{
			Connection conn = DBConnection.getCnnection();
			String sql = "insert into bespoke (b_userid,b_username,b_type,b_pet,b_tel,b_date,b_sign) values(?,?,?,?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,type);
			ps.setString(4,pet);
			ps.setString(5,tel);
			ps.setString(6,date);
			ps.setInt(7, b_sign);
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
