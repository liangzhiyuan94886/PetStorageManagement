package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Javabean.Pet_Info;

import sql_link.DBConnection;

public class UpdatePetInfoDao{
	//更新图片
	public  boolean  UpdatePetInfo(Pet_Info pi){
		boolean flag = false;
		Connection con = DBConnection.getCnnection();
		String sql = "update petinfo set p_user=?,p_tel=?,p_type=?,p_pet=?,p_combo=?,p_price1=?,p_other=?,p_price2=?,p_notes=?,p_time=?,p_filename=?,p_operator=? where p_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pi.getP_user());
			ps.setString(2, pi.getP_tel());
			ps.setString(3, pi.getP_type());
			ps.setString(4, pi.getP_pet());
			ps.setString(5, pi.getP_combo());
			ps.setDouble(6, pi.getP_price1());
			ps.setString(7, pi.getP_other());
			ps.setDouble(8, pi.getP_price2());
			ps.setString(9, pi.getP_notes());
			ps.setString(10, pi.getP_time());
			ps.setString(11, pi.getP_filename());
			ps.setString(12, pi.getP_operator());
			ps.setInt(13, pi.getP_id());
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
		public  boolean  UpdatePetInfoNoJPG(Pet_Info pi){
			boolean flag = false;
			Connection con = DBConnection.getCnnection();
			String sql = "update petinfo set p_user=?,p_tel=?,p_type=?,p_pet=?,p_combo=?,p_price1=?,p_other=?,p_price2=?,p_notes=?,p_time=?,p_operator=? where p_id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, pi.getP_user());
				ps.setString(2, pi.getP_tel());
				ps.setString(3, pi.getP_type());
				ps.setString(4, pi.getP_pet());
				ps.setString(5, pi.getP_combo());
				ps.setDouble(6, pi.getP_price1());
				ps.setString(7, pi.getP_other());
				ps.setDouble(8, pi.getP_price2());
				ps.setString(9, pi.getP_notes());
				ps.setString(10, pi.getP_time());
			//	ps.setString(11, pi.getP_filename());
				ps.setString(11, pi.getP_operator());
				ps.setInt(12, pi.getP_id());
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
