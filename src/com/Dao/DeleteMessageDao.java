package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql_link.DBConnection;

public class DeleteMessageDao {
	//删除留言
	public boolean DeleteMessage(int id){
		boolean flag  = false;
		Connection con = DBConnection.getCnnection();
		String sql = "delete from message where m_id=?";
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
	
	
	//删除不需要的预约寄存信息
	public boolean DeleteBespoke(int id){
		boolean flag  = false;
		Connection con = DBConnection.getCnnection();
		String sql = "delete from bespoke where b_id=?";
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
