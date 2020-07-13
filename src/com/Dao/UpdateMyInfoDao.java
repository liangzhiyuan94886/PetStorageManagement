package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Javabean.Pet_Admin;

import sql_link.DBConnection;


public class UpdateMyInfoDao {
	//更新图片
	public  boolean  UpdateMyInfo(Pet_Admin pi){
		boolean flag = false;
		Connection con = DBConnection.getCnnection();
		String sql = "update admin set a_number=?,a_name=?,a_sex=?,a_idcard=?,a_tel=?,a_address=?,a_notes=?,a_filename=? where a_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pi.getA_number());
			ps.setString(2, pi.getA_name());
			ps.setString(3, pi.getA_sex());
			ps.setString(4, pi.getA_idcard());
			ps.setString(5, pi.getA_tel());
			ps.setString(6, pi.getA_address());
			ps.setString(7, pi.getA_notes());
			ps.setString(8, pi.getA_filename());
			ps.setInt(9, pi.getA_id());
			int a = ps.executeUpdate();
			if(a>0){
				flag = true;
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
}

	
	//不不不更新图片
		public  boolean  UpdateMyInfoNOJPG(Pet_Admin pi){
			boolean flag = false;
			Connection con = DBConnection.getCnnection();
			String sql = "update admin set a_number=?,a_name=?,a_sex=?,a_idcard=?,a_tel=?,a_address=?,a_notes=? where a_id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, pi.getA_number());
				ps.setString(2, pi.getA_name());
				ps.setString(3, pi.getA_sex());
				ps.setString(4, pi.getA_idcard());
				ps.setString(5, pi.getA_tel());
				ps.setString(6, pi.getA_address());
				ps.setString(7, pi.getA_notes());
				ps.setInt(8, pi.getA_id());
				int a = ps.executeUpdate();
				if(a>0){
					flag = true;
				}
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
	}
}
