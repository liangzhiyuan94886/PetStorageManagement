package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import sql_link.DBConnection;

public class AddFeederInfoDao {
	public  boolean  addfeederinfo(String f_number,String f_name,String f_sex,String f_idcard,String f_tel,String f_address,String f_notes,String f_filename){
		boolean flag = false;
		try{
			Connection conn = DBConnection.getCnnection();
			System.out.println("数据库连接成功");
			
			String sql = "insert into feederinfo (f_number,f_name,f_sex,f_idcard,f_tel,f_address,f_notes,f_filename) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setString(1,f_number);
			ps.setString(2,f_name);
			ps.setString(3,f_sex);
			ps.setString(4,f_idcard);
			ps.setString(5,f_tel);
			ps.setString(6,f_address);
			ps.setString(7,f_notes);
			ps.setString(8, f_filename);
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

}
