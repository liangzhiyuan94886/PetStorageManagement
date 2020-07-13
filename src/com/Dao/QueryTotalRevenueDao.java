package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import sql_link.DBConnection;

public class QueryTotalRevenueDao {
	
	//查总收入
		public Integer querytotalrevenueByAll() {
			Integer n0=0;
			try {
				Connection con = DBConnection.getCnnection();
				String sql = "select SUM(p_spend) from PetInfo where p_sign = '2'";
				Statement st = con.createStatement();
				// 查询语句返回的是一个结果集ResultSet
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					n0=(int) rs.getDouble(1);
				}
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return n0;
		}
	
//查宠物狗的总收入
	public Integer querytotalrevenueByDog() {
		Integer n1=0;
		/*List<Pet_Info> revenue = new ArrayList<Pet_Info>();
		Pet_Info eu = null;*/
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select SUM(p_spend) from PetInfo where p_type='宠物狗' and p_sign = '2'";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				/*eu = new Pet_Info();
				eu.setP_spend(rs.getDouble(1));
				revenue.add(eu);*/
				n1=(int) rs.getDouble(1);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n1;
	}
//查宠物猫总收入
	public Integer querytotalrevenueByCat() {
		Integer n2=0;
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select SUM(p_spend) from PetInfo where p_type='宠物猫' and p_sign = '2'";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				n2=(int) rs.getDouble(1);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n2;
	}
	
//查其他宠物的总收入
	public Integer querytotalrevenueByOther() {
		Integer n3 = 0;
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select SUM(p_spend) from PetInfo where p_type='其他宠物' and p_sign = '2'";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				n3=(int) rs.getDouble(1);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n3;
	}	
	

}
