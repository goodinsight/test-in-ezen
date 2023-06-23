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
import java.sql.SQLException;
import java.util.Scanner;

public class DBUpdateTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		
//		사원의 정보를 수정해보자
		System.out.print("수정하실 사원번호를 입력 : ");
		int empno = Integer.parseInt(scan.nextLine());
		System.out.print("변경하실 사원의 이름을 입력 : ");
		String ename = scan.nextLine();
		System.out.print("변경하실 직업을 입력 : ");
		String job = scan.nextLine();
		System.out.print("변경하실 급여를 입력 : ");
		int sal = Integer.parseInt(scan.nextLine());
		
		try {
//			구동드라이브 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("com.mysql.jdbc.Driver"); 6이하버전
//			Class.forName("oracle.jdbc.driver.OracleDriver"); 오라클일때
			
//			접속하기
			String url = "jdbc:mysql://localhost:3306/scott?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			String user = "root";
			String password = "12345";
			
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공 !!!!!");
			
			String sql = "UPDATE EMP ";
				   sql += "SET ename = ?, job = ?, sal = ? ";
				   sql += "WHERE empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setString(2, job);
			pstmt.setInt(3, sal);
			pstmt.setInt(4, empno);
			
			int result = pstmt.executeUpdate();
			if(result < 0)
				System.out.println("수정에 실패하였습니다.");
			else
				System.out.println("성공적으로 변경되었습니다.");
			
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
