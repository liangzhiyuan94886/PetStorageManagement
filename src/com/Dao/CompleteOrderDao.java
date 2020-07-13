package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sql_link.DBConnection;


public class CompleteOrderDao {
	public boolean CompleteOrder(Integer id,String operator,String nowtime,Integer day,Integer hour,Double spend,Integer sign){
		boolean flag = false;
		try{
			Connection con = DBConnection.getCnnection();
			String sql = "update petinfo set p_leavetime=?,p_day=?,p_hours=?,p_spend=?,p_sign=?,p_operator=? where p_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nowtime);
			ps.setInt(2, day);
			ps.setInt(3, hour);
			ps.setDouble(4, spend);
			ps.setInt(5, sign);
			ps.setString(6, operator);
			ps.setInt(7, id);
			int a = ps.executeUpdate();
			if(a > 0){
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
