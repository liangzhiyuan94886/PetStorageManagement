package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import sql_link.DBConnection;

public class UserRegistDao {
	public  boolean  insertUser(String userName,String userPassword,String mail,String tel){
		boolean flag = false;
		//Pet_User pu = new Pet_User();
		try{
			Connection conn = DBConnection.getCnnection();
			System.out.println("数据库连接成功");
			
			String sql = "insert into user (userName,userPassword,mail,tel) values(?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setString(1,userName);
			ps.setString(2,userPassword);
			ps.setString(3,mail);
			ps.setString(4,tel);
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
