/*
 * �����ͺ��̽� ���� �׽�Ʈ : mySQL
 * jar ���� : mysql-connector-j-8.0.33.jar
 * 
 * [�ʿ��� Ŭ����]
 * Connection Ŭ���� : �ּ�(port), ����, �н�����
 * DriverManager Ŭ���� 
 * Class.forName("��������̺�")
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
		

//		�˻��� ����� �Է��ϱ�
		System.out.print("�˻��� ����� : ");
		String ename = scan.nextLine();
		
		try {
//			��������̺� ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			�����ϱ�
			String url = "jdbc:mysql://localhost:3306/scott?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			String user = "root";
			String password = "12345";
			
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("���� ���� !!!!!");
			
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
			System.out.println("���� ����̺갡 �����ϴ�.");
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			System.out.println("���� : ");
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
