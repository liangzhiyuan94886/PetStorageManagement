package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql_link.DBConnection;

import com.Javabean.Pet_Admin;

public class UpdateAccountInfoDao {
	// 更新管理员图片
	public boolean UpdateAccountInfoAndJPG(Pet_Admin pi) {
		boolean flag = false;
		Connection con = DBConnection.getCnnection();
		String sql = "update admin set a_admin=?,a_password=?, a_number=?,a_name=?,a_sex=?,a_idcard=?,a_tel=?,a_address=?,a_notes=?,a_filename=? where a_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pi.getA_admin());
			ps.setString(2, pi.getA_password());
			ps.setString(3, pi.getA_number());
			ps.setString(4, pi.getA_name());
			ps.setString(5, pi.getA_sex());
			ps.setString(6, pi.getA_idcard());
			ps.setString(7, pi.getA_tel());
			ps.setString(8, pi.getA_address());
			ps.setString(9, pi.getA_notes());
			ps.setString(10, pi.getA_filename());
			ps.setInt(11, pi.getA_id());
			int a = ps.executeUpdate();
			if (a > 0) {
				flag = true;
			}
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	
	// 不不不不不更新管理员图片
	public boolean UpdateAccountInfoNoJPG(Pet_Admin pi) {
		boolean flag = false;
		Connection con = DBConnection.getCnnection();
		String sql = "update admin set a_admin=?,a_password=?, a_number=?,a_name=?,a_sex=?,a_idcard=?,a_tel=?,a_address=?,a_notes=? where a_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pi.getA_admin());
			ps.setString(2, pi.getA_password());
			ps.setString(3, pi.getA_number());
			ps.setString(4, pi.getA_name());
			ps.setString(5, pi.getA_sex());
			ps.setString(6, pi.getA_idcard());
			ps.setString(7, pi.getA_tel());
			ps.setString(8, pi.getA_address());
			ps.setString(9, pi.getA_notes());
			ps.setInt(10, pi.getA_id());
			int a = ps.executeUpdate();
			if (a > 0) {
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
