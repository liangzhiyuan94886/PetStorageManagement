package sql_link;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        getCnnection();
	}

	public static Connection getCnnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/petmanagement";
			conn =  DriverManager.getConnection(url,"root","Abc.123456");
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败");
			e.printStackTrace();
			
		}
		
		return conn;
	}

	

}
