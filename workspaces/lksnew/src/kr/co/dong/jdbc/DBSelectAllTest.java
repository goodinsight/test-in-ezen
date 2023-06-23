/*
 * 1. DB연결
 * 2. 질의문 작성 -> 실행
 * 3. 실행결과를 보관
 * 
 */

package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSelectAllTest {
	public static void main(String[] args) {
		Connection conn = null;	// 데이터베이스 연결
		Statement stmt = null;	// 질의문 작성, 실행
		ResultSet rs = null;	// 결과값 보관
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			접속하기
			String url = "jdbc:mysql://localhost:3306/scott";
			String id = "root";
			String pw = "12345";
			
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("연결성공 !!!");
			
//			2-1.질의문 작성하기
			String sql = "select empno, ename from emp";
//			2-2.stmt 생성
			stmt = conn.createStatement();
//			2-3.stmt 실행 -> return 값 : ResultSet
			rs = stmt.executeQuery(sql);	// select
//			rs = stmt.executeUpdate(sql); // select 이외
					
			System.out.println("사원번호 : 사원명");
			while(rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print("  :  " + rs.getString(2) + "\n");
			}
			
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
			System.out.println("연결 실패");
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			System.out.println("에러");
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
