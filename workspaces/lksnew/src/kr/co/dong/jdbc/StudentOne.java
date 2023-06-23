/**
 * �л� ��ȸ
 * (���� or �й� or �̸�����)
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

public class StudentOne {
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
			
			System.out.println("� ������� �л��� ��ȸ�Ͻðڽ��ϱ�?");
			System.out.println("1.����  2.�й�  3.�̸�");
			String sql = "";
			switch (scan.nextLine()) {
			case "1":
				//�������� ��ȸ
				sql = "SELECT * FROM STUDENT ";
				sql += "WHERE SID = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("�л��� ������ �Է� : ");
				pstmt.setInt(1, Integer.parseInt(scan.nextLine()));
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
				}
				if(list.size() == 0)
					System.out.println("�ش� �л��� ��ȸ�� ���� �ʽ��ϴ�.");
				for(StudentBean sb : list)
					System.out.println(sb);
				break;
			case "2":
				//�й����� ��ȸ
				sql = "SELECT * FROM STUDENT ";
				sql += "WHERE NUM = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("�л��� �й��� �Է� : ");
				pstmt.setInt(1, Integer.parseInt(scan.nextLine()));
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
				}
				
				if(list.size() == 0)
					System.out.println("�ش� �л��� ��ȸ�� ���� �ʽ��ϴ�.");
				for(StudentBean sb : list)
					System.out.println(sb);
				break;
			case "3":
				//�̸����� ��ȸ
				sql = "SELECT * FROM STUDENT ";
				sql += "WHERE NAME = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("�л��� �̸��� �Է� : ");
				pstmt.setString(1, scan.nextLine());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
				}
				
				if(list.size() == 0)
					System.out.println("�ش� �л��� ��ȸ�� ���� �ʽ��ϴ�.");
				for(StudentBean sb : list)
					System.out.println(sb);
				break;
				
			default:
				break;
			}
			
			
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
		
	scan.close();	
	}
	
}
