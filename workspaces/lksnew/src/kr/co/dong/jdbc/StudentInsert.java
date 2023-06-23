/**
 * �л� �߰�
 * 
 */
package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentInsert {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudentBean> list = new ArrayList<StudentBean>();
		Scanner scan = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/testdb?user=root&password=12345";
			conn = DriverManager.getConnection(url);
			System.out.println("����Ϸ�");
			
			String sql = "INSERT INTO STUDENT ";
				   sql += "(sid, name, age, num, major) ";
				   sql += "VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			System.out.println("�л��� �߰��մϴ�.");
			System.out.print("������ �Է� : ");
			pstmt.setInt(1, Integer.parseInt(scan.nextLine()));
			System.out.print("�̸��� �Է� : ");
			pstmt.setString(2, scan.nextLine());
			System.out.print("���̸� �Է� : ");
			pstmt.setInt(3, Integer.parseInt(scan.nextLine()));
			System.out.print("�й��� �Է� : ");
			pstmt.setInt(4, Integer.parseInt(scan.nextLine()));
			System.out.print("�а��� �Է� : ");
			pstmt.setString(5, scan.nextLine());
			
			int result = pstmt.executeUpdate();
			
			if(result < 0)
				System.out.println("�л� �߰��� �����Ͽ����ϴ�.");
			else if(result > 0)
				System.out.println("�л� �߰� ����!!!");
			
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
