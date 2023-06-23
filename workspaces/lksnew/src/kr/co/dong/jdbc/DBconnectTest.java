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
import java.sql.SQLException;

public class DBconnectTest {
	public static void main(String[] args) {
		Connection conn = null;
		
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
