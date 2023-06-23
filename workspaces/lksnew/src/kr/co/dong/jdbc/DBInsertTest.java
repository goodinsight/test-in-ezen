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

public class DBInsertTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		
//		��� �߰��ϱ�
		System.out.print("�����ȣ(7xxx) : ");
		int empno = Integer.parseInt(scan.nextLine());
		System.out.print("����� : ");
		String ename = scan.nextLine();
		System.out.print("���� : ");
		String job = scan.nextLine();
		System.out.println("�����ȣ : ");
		int mgr = Integer.parseInt(scan.nextLine());
		System.out.println("�Ի��� : ");
		String hiredate = scan.nextLine();
		System.out.print("�޿� : ");
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
				System.out.println("������ �߰� ����");
			else
				System.out.println("��������� �߰� ����!");
				   
				   
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
