/**
 * �л� ����
 * 
 */
package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDelete {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/testdb?user=root&password=12345";
			conn = DriverManager.getConnection(url);
			System.out.println("����Ϸ�");
			
			String sql = "DELETE FROM STUDENT ";
				   sql += "WHERE sid = ?";
			pstmt = conn.prepareStatement(sql);
			System.out.println("�����Ͻ� �л��� ������ �Է� : ");
			pstmt.setString(1, scan.nextLine());
			
			int result = pstmt.executeUpdate();
			
			if(result < 0)
				System.out.println("�л����� ������ �����Ͽ����ϴ�.");
			else if(result > 0)
				System.out.println("�л����� ���� ����!!!");
			
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
			System.out.println("����̹��� �������� �ʽ��ϴ�.");
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			System.out.println("���� : ");
		} finally {
			try {
				conn.close();
				System.out.println("���� ����");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
