package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql_link.DBConnection;

public class DeleteFeederInfoDao {
	//删除饲养员
	public boolean deletefeederinfo(int id){
		boolean flag  = false;
		Connection con = DBConnection.getCnnection();
		String sql = "delete from feederinfo where f_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int a = ps.executeUpdate();
			if(a>0){
				flag = true;
			}
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	//删除管理员
	public boolean deleteadmininfo(int id){
		boolean flag  = false;
		Connection con = DBConnection.getCnnection();
		String sql = "delete from admin where a_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int a = ps.executeUpdate();
			if(a>0){
				flag = true;
			}
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
