/*
 * 데이터베이스 연결 테스트 : mySQL
 * jar 파일 : mysql-connector-j-8.0.33.jar
 * 
 * [필요한 클래스]
 * Connection 클래스 : 주소(port), 유저, 패스워드
 * DriverManager 클래스 
 * Class.forName("구동드라이브")
 * 
 */

package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBSelectOneTest2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpBean eb = null;
		Scanner scan = new Scanner(System.in);
		

//		검색할 사원명 입력하기
		System.out.print("검색할 사원명 : ");
		String ename = scan.nextLine();
		
		try {
//			구동드라이브 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			접속하기
			String url = "jdbc:mysql://localhost:3306/scott?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			String user = "root";
			String password = "12345";
			
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공 !!!!!");
			
			String sql = "select empno, ename from emp where ename = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				eb = new EmpBean(rs.getInt(1), rs.getString(2), null, 0, null, 0, 0, 0);
			}
			
			System.out.println(eb);
		
		
		
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
			System.out.println("연결 드라이브가 없습니다.");
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			System.out.println("에러 : ");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
