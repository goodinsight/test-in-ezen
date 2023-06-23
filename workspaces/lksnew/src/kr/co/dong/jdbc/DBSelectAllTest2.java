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
import java.util.ArrayList;
import java.util.List;

public class DBSelectAllTest2 {
	public static void main(String[] args) {
		Connection conn = null;	// �����ͺ��̽� ����
		Statement stmt = null;	// ���ǹ� �ۼ�, ����
		ResultSet rs = null;	// ����� ����
		List<EmpBean> list = new ArrayList<EmpBean>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			�����ϱ�
			String url = "jdbc:mysql://localhost:3306/scott";
			String id = "root";
			String pw = "12345";
			
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("���Ἲ�� !!!");
			
			String sql = "select empno, ename from emp";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new EmpBean(rs.getInt(1), rs.getString(2), null, 0, null, 0, 0, 0));
			}
			
			System.out.println(" �����ȣ  : �����     LIST");
			for(EmpBean eb : list) {
				System.out.print(eb.getEmpno() + "  :  " + eb.getEname() + "\n");
			}
			
			
			
			
			
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
			System.out.println("���� ����̺갡 �����ϴ�.");
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
