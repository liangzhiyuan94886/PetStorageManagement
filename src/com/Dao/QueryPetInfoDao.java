package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Javabean.Pet_Info;
import sql_link.DBConnection;

public class QueryPetInfoDao {
	public List<Pet_Info> queryPetInfo() {
		List<Pet_Info> lst = new ArrayList<Pet_Info>();
		try {
			Connection con = DBConnection.getCnnection();
			String sql = "select * from PetInfo where p_sign = '1' order by p_time desc";
			Statement st = con.createStatement();
			// 查询语句返回的是一个结果集ResultSet
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				/*Date currentTime = rs.getDate(11);
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 String dateString = formatter.format(currentTime);*/
				Pet_Info eu = new Pet_Info();
				eu.setP_id(rs.getInt(1));
				eu.setP_user(rs.getString(2));
				eu.setP_tel(rs.getString(3));
				eu.setP_type(rs.getString(4));
				eu.setP_pet(rs.getString(5));
				eu.setP_combo(rs.getString(6));
				eu.setP_price1(rs.getDouble(7));
				eu.setP_other(rs.getString(8));
				eu.setP_price2(rs.getDouble(9));
		//		eu.setP_notes(rs.getString(10));
				eu.setP_time(rs.getString(11));
		//		eu.setP_sign(rs.getInt(10));
				lst.add(eu);
			}
//			System.out.println(lst.size());
//			System.out.println(lst.get(1).getD_user());
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;

	}

}
