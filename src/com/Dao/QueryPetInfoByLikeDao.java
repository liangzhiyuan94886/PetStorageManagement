package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import sql_link.DBConnection;
import com.Javabean.Pet_Info;

public class QueryPetInfoByLikeDao {
	//全都不为空
	public ArrayList<Pet_Info> QueryPetInfoByAll(String content1,String content2,String date1,String date2){
	ArrayList<Pet_Info> querylist = new ArrayList<Pet_Info>();
	Connection con = DBConnection.getCnnection();
	String sql = "select * from petinfo where (p_user like '%"+content1+"%' or p_tel like '%"+content1+"%' or p_type like '%"+content1+"%') and (p_combo like '%"+content2+"%' or p_other like '%"+content2+"%') and (p_time between '"+date1+"' and '"+date2+"') and p_sign = 1 ";
	try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			/*//转时间
			 Date currentTime = rs.getDate(11);
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 String dateString = formatter.format(currentTime);*/
			 
			Pet_Info like = new Pet_Info();
			like.setP_id(rs.getInt(1));
			like.setP_user(rs.getString(2));
			like.setP_tel(rs.getString(3));
			like.setP_type(rs.getString(4));
			like.setP_pet(rs.getString(5));
			like.setP_combo(rs.getString(6));
			like.setP_other(rs.getString(8));
			like.setP_time(rs.getString(11));
			like.setP_sign(rs.getInt(16));
			querylist.add(like);
		}
		con.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
    return querylist;
}
	
	//都为空
	public ArrayList<Pet_Info> QueryPetInfoByNull(){
		ArrayList<Pet_Info> querylist = new ArrayList<Pet_Info>();
		Connection con = DBConnection.getCnnection();
		String sql = "select * from petinfo where p_sign = 1 ";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				/*//转时间
				 Date currentTime = rs.getDate(11);
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 String dateString = formatter.format(currentTime);*/
				 
				Pet_Info like = new Pet_Info();
				like.setP_id(rs.getInt(1));
				like.setP_user(rs.getString(2));
				like.setP_tel(rs.getString(3));
				like.setP_type(rs.getString(4));
				like.setP_pet(rs.getString(5));
				like.setP_combo(rs.getString(6));
				like.setP_other(rs.getString(8));
				like.setP_time(rs.getString(11));
				like.setP_sign(rs.getInt(16));
				querylist.add(like);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return querylist;
	}

//content1不为空
	public ArrayList<Pet_Info> QueryPetInfoByContent1(String content1){
	ArrayList<Pet_Info>querylist = new ArrayList<Pet_Info>();
	Connection con = DBConnection.getCnnection();
	String sql = "select * from petinfo where (p_user like '%"+content1+"%' or p_tel like '%"+content1+"%' or p_type like '%"+content1+"%') and p_sign = 1 ";
	try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			Pet_Info like = new Pet_Info();
			like.setP_id(rs.getInt(1));
			like.setP_user(rs.getString(2));
			like.setP_tel(rs.getString(3));
			like.setP_type(rs.getString(4));
			like.setP_pet(rs.getString(5));
			like.setP_combo(rs.getString(6));
			like.setP_other(rs.getString(8));
			like.setP_time(rs.getString(11));
			like.setP_sign(rs.getInt(16));
			querylist.add(like);
		}
		con.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
    return querylist;
}
	
	//content1和content2不为空
	public ArrayList<Pet_Info> QueryPetInfoBycontent1Andcontent2(String content1,String content2){
		ArrayList<Pet_Info>querylist = new ArrayList<Pet_Info>();
		Connection con = DBConnection.getCnnection();
		String sql = "select * from petinfo where (p_user like '%"+content1+"%' or p_tel like '%"+content1+"%' or p_type like '%"+content1+"%')and (p_combo like '%"+content2+"%' or p_other like '%"+content2+"%') and p_sign = 1 ";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Pet_Info like = new Pet_Info();
				like.setP_id(rs.getInt(1));
				like.setP_user(rs.getString(2));
				like.setP_tel(rs.getString(3));
				like.setP_type(rs.getString(4));
				like.setP_pet(rs.getString(5));
				like.setP_combo(rs.getString(6));
				like.setP_other(rs.getString(8));
				like.setP_time(rs.getString(11));
				like.setP_sign(rs.getInt(16));
				querylist.add(like);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return querylist;
	}	
	
	//content1和时间不为空
	public ArrayList<Pet_Info> QueryPetInfoByDayAndContent1(String content1,String date1,String date2){
		ArrayList<Pet_Info>querylist = new ArrayList<Pet_Info>();
		Connection con = DBConnection.getCnnection();
		String sql = "select * from petinfo where (p_user like '%"+content1+"%' or p_tel like '%"+content1+"%' or p_type like '%"+content1+"%')and (p_time between '"+date1+"' and '"+date2+"') and p_sign = 1 ";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Pet_Info like = new Pet_Info();
				like.setP_id(rs.getInt(1));
				like.setP_user(rs.getString(2));
				like.setP_tel(rs.getString(3));
				like.setP_type(rs.getString(4));
				like.setP_pet(rs.getString(5));
				like.setP_combo(rs.getString(6));
				like.setP_other(rs.getString(8));
				like.setP_time(rs.getString(11));
				like.setP_sign(rs.getInt(16));
				querylist.add(like);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return querylist;
	}	
	
	//content2不为空，content1和时间为空
	public ArrayList<Pet_Info> QueryPetInfoByContent2(String content2){
		ArrayList<Pet_Info>querylist = new ArrayList<Pet_Info>();
		Connection con = DBConnection.getCnnection();
		String sql = "select * from petinfo where (p_combo like '%"+content2+"%' or p_other like '%"+content2+"%') and p_sign = 1 ";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Pet_Info like = new Pet_Info();
				like.setP_id(rs.getInt(1));
				like.setP_user(rs.getString(2));
				like.setP_tel(rs.getString(3));
				like.setP_type(rs.getString(4));
				like.setP_pet(rs.getString(5));
				like.setP_combo(rs.getString(6));
				like.setP_other(rs.getString(8));
				like.setP_time(rs.getString(11));
				like.setP_sign(rs.getInt(16));
				querylist.add(like);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return querylist;
	}
	
	//content2和时间不为空，content1为空
	public ArrayList<Pet_Info> QueryPetInfoByContent2AndDay(String content2,String date1,String date2){
		ArrayList<Pet_Info>querylist = new ArrayList<Pet_Info>();
		Connection con = DBConnection.getCnnection();
		String sql = "select * from petinfo where (p_combo like '%"+content2+"%' or p_other like '%"+content2+"%') and (p_time between '"+date1+"' and '"+date2+"') and p_sign = 1 ";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Pet_Info like = new Pet_Info();
				like.setP_id(rs.getInt(1));
				like.setP_user(rs.getString(2));
				like.setP_tel(rs.getString(3));
				like.setP_type(rs.getString(4));
				like.setP_pet(rs.getString(5));
				like.setP_combo(rs.getString(6));
				like.setP_other(rs.getString(8));
				like.setP_time(rs.getString(11));
				like.setP_sign(rs.getInt(16));
				querylist.add(like);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return querylist;
	}
	
	//时间不为空，content1和content2为空
	public ArrayList<Pet_Info> QueryPetInfoByDay(String date1,String date2){
		ArrayList<Pet_Info>querylist = new ArrayList<Pet_Info>();
		Connection con = DBConnection.getCnnection();
		String sql = "select * from petinfo where (p_time between '"+date1+"' and '"+date2+"') and p_sign = 1 ";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Pet_Info like = new Pet_Info();
				like.setP_id(rs.getInt(1));
				like.setP_user(rs.getString(2));
				like.setP_tel(rs.getString(3));
				like.setP_type(rs.getString(4));
				like.setP_pet(rs.getString(5));
				like.setP_combo(rs.getString(6));
				like.setP_other(rs.getString(8));
				like.setP_time(rs.getString(11));
				like.setP_sign(rs.getInt(16));
				querylist.add(like);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return querylist;
	}
}