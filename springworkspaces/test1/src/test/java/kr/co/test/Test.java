package kr.co.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/moviedb?";
			String username = "root";
			String password = "12345";
				
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("연결성공");
			
			String sql = "select * from movie";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String m_age = rs.getString(6);
				
				if(m_age.equals("null")) {
					System.out.println("null입니다.");
				}else {
					System.out.println("값이 있습니다.");
				}
				
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
