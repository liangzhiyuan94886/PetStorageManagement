package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql_link.DBConnection;

public class AddPetInfoDao {
	////预约寄存的用户  多 存一个用户的ID
	public  boolean  insertPetInfoAndUserid(String p_operator,String p_user,String p_tel,String p_type,String p_pet,String p_combo,Double p_price1,String p_other,Double p_price2,String p_notes,String p_time,Integer p_sign,String p_filename,Integer p_userid){
		boolean flag = false;
		try{
			Connection conn = DBConnection.getCnnection();
			//System.out.println("数据库连接成功");
			String sql = "insert into PetInfo (p_user,p_tel,p_type,p_pet,p_combo,p_price1,p_other,p_price2,p_notes,p_time,p_sign,p_filename,p_operator,p_userid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setString(1,p_user);
			ps.setString(2,p_tel);
			ps.setString(3,p_type);
			ps.setString(4,p_pet);
			ps.setString(5,p_combo);
			ps.setDouble(6,p_price1);
			ps.setString(7,p_other);
			ps.setDouble(8,p_price2);
			ps.setString(9,p_notes);
			ps.setString(10,p_time);
			ps.setInt(11,p_sign);
			ps.setString(12,p_filename);
			ps.setString(13, p_operator);
			ps.setInt(14, p_userid);
			int n = ps.executeUpdate();
			if (n > 0) {
				flag = true;
		}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	
	
	
//普通用户来店寄存 不存ID
	public  boolean  insertPetInfoNoUserid(String p_operator,String p_user,String p_tel,String p_type,String p_pet,String p_combo,Double p_price1,String p_other,Double p_price2,String p_notes,String p_time,Integer p_sign,String p_filename){
		boolean flag = false;
		try{
			Connection conn = DBConnection.getCnnection();
			//System.out.println("数据库连接成功");
			String sql = "insert into PetInfo (p_user,p_tel,p_type,p_pet,p_combo,p_price1,p_other,p_price2,p_notes,p_time,p_sign,p_filename,p_operator) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setString(1,p_user);
			ps.setString(2,p_tel);
			ps.setString(3,p_type);
			ps.setString(4,p_pet);
			ps.setString(5,p_combo);
			ps.setDouble(6,p_price1);
			ps.setString(7,p_other);
			ps.setDouble(8,p_price2);
			ps.setString(9,p_notes);
			ps.setString(10,p_time);
			ps.setInt(11,p_sign);
			ps.setString(12,p_filename);
			ps.setString(13, p_operator);
			int n = ps.executeUpdate();
			if (n > 0) {
				flag = true;
		}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	
	
	//如果是通过预约寄存添加的，给已完成预约订单update一个b_sign=2
	public boolean  UpdateBespokeTo2(Integer b_sign,Integer b_id){
		boolean flag2 = false;
		Connection con = DBConnection.getCnnection();
		String sql = "update bespoke set b_sign=? where b_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, b_sign);
			ps.setInt(2, b_id);
			int a = ps.executeUpdate();
			if(a>0){
				flag2 = true;
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag2;	
	}
}
