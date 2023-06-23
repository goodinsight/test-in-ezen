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
import java.sql.SQLException;
import java.util.Scanner;

public class DBUpdateTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		
//		����� ������ �����غ���
		System.out.print("�����Ͻ� �����ȣ�� �Է� : ");
		int empno = Integer.parseInt(scan.nextLine());
		System.out.print("�����Ͻ� ����� �̸��� �Է� : ");
		String ename = scan.nextLine();
		System.out.print("�����Ͻ� ������ �Է� : ");
		String job = scan.nextLine();
		System.out.print("�����Ͻ� �޿��� �Է� : ");
		int sal = Integer.parseInt(scan.nextLine());
		
		try {
//			��������̺� ����
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("com.mysql.jdbc.Driver"); 6���Ϲ���
//			Class.forName("oracle.jdbc.driver.OracleDriver"); ����Ŭ�϶�
			
//			�����ϱ�
			String url = "jdbc:mysql://localhost:3306/scott?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			String user = "root";
			String password = "12345";
			
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("���� ���� !!!!!");
			
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
				System.out.println("������ �����Ͽ����ϴ�.");
			else
				System.out.println("���������� ����Ǿ����ϴ�.");
			
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
