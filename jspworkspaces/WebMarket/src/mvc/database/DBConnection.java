package mvc.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException  {		

		Connection conn = null;		
	

		try {
			String url = "jdbc:mysql://localhost:3306/WebMarketDB?serverTimezone=UTC";
			String user = "root";
			String password = "12345";

			// 오라클일때
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Class.forName("com.mysql.jdbc.Driver");   7.0이하
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return conn;
	}	
}
