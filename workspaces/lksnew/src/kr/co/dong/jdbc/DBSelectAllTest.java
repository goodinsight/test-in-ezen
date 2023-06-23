/*
 * 1. DB����
 * 2. ���ǹ� �ۼ� -> ����
 * 3. �������� ����
 * 
 */

package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSelectAllTest {
	public static void main(String[] args) {
		Connection conn = null;	// �����ͺ��̽� ����
		Statement stmt = null;	// ���ǹ� �ۼ�, ����
		ResultSet rs = null;	// ����� ����
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			�����ϱ�
			String url = "jdbc:mysql://localhost:3306/scott";
			String id = "root";
			String pw = "12345";
			
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("���Ἲ�� !!!");
			
//			2-1.���ǹ� �ۼ��ϱ�
			String sql = "select empno, ename from emp";
//			2-2.stmt ����
			stmt = conn.createStatement();
//			2-3.stmt ���� -> return �� : ResultSet
			rs = stmt.executeQuery(sql);	// select
//			rs = stmt.executeUpdate(sql); // select �̿�
					
			System.out.println("�����ȣ : �����");
			while(rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print("  :  " + rs.getString(2) + "\n");
			}
			
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
			System.out.println("���� ����");
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			System.out.println("����");
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
