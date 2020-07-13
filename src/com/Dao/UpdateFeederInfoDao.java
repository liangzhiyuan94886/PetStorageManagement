package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Javabean.Pet_Feeder;

import sql_link.DBConnection;



public class UpdateFeederInfoDao {
	//更新图片
		public  boolean  UpdateFeederInfo(Pet_Feeder pi){
			boolean flag = false;
			Connection con = DBConnection.getCnnection();
			String sql = "update feederinfo set f_number=?,f_name=?,f_sex=?,f_idcard=?,f_tel=?,f_address=?,f_notes=?,f_filename=? where f_id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, pi.getF_number());
				ps.setString(2, pi.getF_name());
				ps.setString(3, pi.getF_sex());
				ps.setString(4, pi.getF_idcard());
				ps.setString(5, pi.getF_tel());
				ps.setString(6, pi.getF_address());
				ps.setString(7, pi.getF_notes());
				ps.setString(8, pi.getF_filename());
				ps.setInt(9, pi.getF_id());
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

	
		//不更新图片
		public  boolean  UpdateFeederInfoNOJPG(Pet_Feeder pi){
			boolean flag = false;
			Connection con = DBConnection.getCnnection();
			String sql = "update feederinfo set f_number=?,f_name=?,f_sex=?,f_idcard=?,f_tel=?,f_address=?,f_notes=? where f_id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, pi.getF_number());
				ps.setString(2, pi.getF_name());
				ps.setString(3, pi.getF_sex());
				ps.setString(4, pi.getF_idcard());
				ps.setString(5, pi.getF_tel());
				ps.setString(6, pi.getF_address());
				ps.setString(7, pi.getF_notes());
				ps.setInt(8, pi.getF_id());
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
