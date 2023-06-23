/**
 * 학생 수정
 * 
 */
package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentUpdate {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/testdb?user=root&password=12345";
			conn = DriverManager.getConnection(url);
			System.out.println("연결완료");
			
			String sql = "UPDATE STUDENT ";
				   sql += "SET name = ?, age = ?, num = ?, major = ? ";
				   sql += "WHERE sid = ?";
			pstmt = conn.prepareStatement(sql);
			System.out.println("수정하실 학생의 순번을 입력 : ");
			pstmt.setInt(5, Integer.parseInt(scan.nextLine()));
			System.out.print("이름을 입력 : ");
			pstmt.setString(1, scan.nextLine());
			System.out.print("나이를 입력 : ");
			pstmt.setInt(2, Integer.parseInt(scan.nextLine()));
			System.out.print("학번을 입력 : ");
			pstmt.setInt(3, Integer.parseInt(scan.nextLine()));
			System.out.print("학과를 입력 : ");
			pstmt.setString(4, scan.nextLine());
			
			int result = pstmt.executeUpdate();
			
			if(result < 0)
				System.out.println("학생정보 수정를 실패하였습니다.");
			else if(result > 0)
				System.out.println("학생정보 수정 성공!!!");
			
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
