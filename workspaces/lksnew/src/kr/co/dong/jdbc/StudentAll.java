/**
 * 전체 조회
 * 
 */
package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentAll {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<StudentBean> list = new ArrayList<StudentBean>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/testdb?user=root&password=12345";
			conn = DriverManager.getConnection(url);
			System.out.println("연결완료");
			
			String sql = "Select * from student";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
			System.out.println("학생정보를 전체조회합니다.");
			for(StudentBean sb : list)
				System.out.println(sb);
			
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
			System.out.println("드라이버가 존재하지 않습니다.");
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			System.out.println("에러 : ");
		} finally {
			try {
				conn.close();
				System.out.println("연결 종료");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
