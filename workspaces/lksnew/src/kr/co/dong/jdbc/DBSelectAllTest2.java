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
import java.util.ArrayList;
import java.util.List;

public class DBSelectAllTest2 {
	public static void main(String[] args) {
		Connection conn = null;	// 데이터베이스 연결
		Statement stmt = null;	// 질의문 작성, 실행
		ResultSet rs = null;	// 결과값 보관
		List<EmpBean> list = new ArrayList<EmpBean>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			접속하기
			String url = "jdbc:mysql://localhost:3306/scott";
			String id = "root";
			String pw = "12345";
			
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("연결성공 !!!");
			
			String sql = "select empno, ename from emp";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new EmpBean(rs.getInt(1), rs.getString(2), null, 0, null, 0, 0, 0));
			}
			
			System.out.println(" 사원번호  : 사원명     LIST");
			for(EmpBean eb : list) {
				System.out.print(eb.getEmpno() + "  :  " + eb.getEname() + "\n");
			}
			
			
			
			
			
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
			System.out.println("연결 드라이브가 없습니다.");
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
