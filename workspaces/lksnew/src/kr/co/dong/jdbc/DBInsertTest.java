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

public class DBInsertTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		
//		사원 추가하기
		System.out.print("사원번호(7xxx) : ");
		int empno = Integer.parseInt(scan.nextLine());
		System.out.print("사원명 : ");
		String ename = scan.nextLine();
		System.out.print("직업 : ");
		String job = scan.nextLine();
		System.out.println("사수번호 : ");
		int mgr = Integer.parseInt(scan.nextLine());
		System.out.println("입사일 : ");
		String hiredate = scan.nextLine();
		System.out.print("급여 : ");
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
			
			String sql = "insert into emp (empno, ename, job, mgr, hiredate, sal) ";
				   sql += "values (?,?,?,?,?,?)";
				   
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, sal);
			
			int result = pstmt.executeUpdate();
			
			if(result <= 0)
				System.out.println("데이터 추가 실패");
			else
				System.out.println("사원데이터 추가 성공!");
				   
				   
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
