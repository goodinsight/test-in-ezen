/**
 * 학생 추가
 * 
 */
package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentInsert {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudentBean> list = new ArrayList<StudentBean>();
		Scanner scan = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/testdb?user=root&password=12345";
			conn = DriverManager.getConnection(url);
			System.out.println("연결완료");
			
			String sql = "INSERT INTO STUDENT ";
				   sql += "(sid, name, age, num, major) ";
				   sql += "VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			System.out.println("학생을 추가합니다.");
			System.out.print("순번을 입력 : ");
			pstmt.setInt(1, Integer.parseInt(scan.nextLine()));
			System.out.print("이름을 입력 : ");
			pstmt.setString(2, scan.nextLine());
			System.out.print("나이를 입력 : ");
			pstmt.setInt(3, Integer.parseInt(scan.nextLine()));
			System.out.print("학번을 입력 : ");
			pstmt.setInt(4, Integer.parseInt(scan.nextLine()));
			System.out.print("학과를 입력 : ");
			pstmt.setString(5, scan.nextLine());
			
			int result = pstmt.executeUpdate();
			
			if(result < 0)
				System.out.println("학생 추가를 실패하였습니다.");
			else if(result > 0)
				System.out.println("학생 추가 성공!!!");
			
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
