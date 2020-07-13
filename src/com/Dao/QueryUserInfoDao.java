package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Javabean.Pet_Info;
import com.Javabean.Pet_User;
import sql_link.DBConnection;

public class QueryUserInfoDao {
//查询用户信息	
	public Pet_User  queryUserByName(String userName){
		Connection con = DBConnection.getCnnection();
		String sql = "select * from user where userName=?";
		Pet_User user = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userName);
			ResultSet rs = ps.executeQuery();
			rs.next();
			user = new Pet_User();
			user.setU_id(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setMail(rs.getString(4));
			user.setTel(rs.getString(5));
			//System.out.println(rs.getString(3));
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
//根据”用户唯一的名字“ 或者“ID”查询用户历史订单
	public List<Pet_Info> QueryUserOrederInfoByDateAndID(String username,Integer u_id) {
		List<Pet_Info> lst = new ArrayList<Pet_Info>();
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from petinfo where p_user=? or p_userid=?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, username);
			st.setInt(2,u_id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Pet_Info eu = new Pet_Info();
			//	eu.setP_id(rs.getInt(1));
				eu.setP_user(rs.getString(2));
				eu.setP_type(rs.getString(4));
				eu.setP_pet(rs.getString(5));
				eu.setP_combo(rs.getString(6));
				eu.setP_price1(rs.getDouble(7));
				eu.setP_other(rs.getString(8));
				eu.setP_price2(rs.getDouble(9));
				eu.setP_time(rs.getString(11));
				eu.setP_leavetime(rs.getString(12));
				eu.setP_day(rs.getInt(13));
				eu.setP_hours(rs.getInt(14));
				eu.setP_spend(rs.getDouble(15));
				eu.setP_filename(rs.getString(17));
				eu.setP_operator(rs.getString(18));
				lst.add(eu);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
	
}
