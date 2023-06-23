package kr.co.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDbCtrl implements StudentCrud {
	private String url = ""; // db �ּ�
	private String user = ""; // db ����id
	private String password = ""; // db ����pw
	public static String drivePath = "com.mysql.cj.jdbc.Driver";
	private Scanner scan = new Scanner(System.in);
	private Connection conn = null;

	public StudentDbCtrl() {

	}

	/**
	 * @param url
	 * @param user
	 * @param password
	 */
	public StudentDbCtrl(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public void connectDb() {
		try {
			Class.forName(StudentDbCtrl.drivePath);
			String url = this.url;
			String user = this.user;
			String password = this.password;
			this.conn = DriverManager.getConnection(url, user, password);
			System.out.println("����Ϸ�");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("����̹��� �������� �ʽ��ϴ�.");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("���� : ");
		}
	}

	public void closeConnection() {
		try {
			conn.close();
			System.out.println("���� ����");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("������ ���������� ������� ���߽��ϴ�.");
		}
	}

	@Override
	public void insertStd() {
		// �л� �߰�
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT ";
		sql += "(sid, name, age, num, major) ";
		sql += "VALUES (?,?,?,?,?)";
		try {
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

			if (result < 0)
				System.out.println("�л� �߰��� �����Ͽ����ϴ�.");
			else if (result > 0)
				System.out.println("�л� �߰� ����!!!");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("���� : ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db�� ������ �� �Ǿ����� Ȯ���غ�����");
		}
	}

	@Override
	public void allSearchStd() {
		// ��ü ��ȸ
		Statement stmt = null;
		ResultSet rs = null;
		List<StudentBean> list = new ArrayList<StudentBean>();

		try {
			String sql = "Select * from student";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				list.add(new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
			System.out.println("�л������� ��ü��ȸ�մϴ�.");
			for (StudentBean sb : list)
				System.out.println(sb);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db�� ������ �� �Ǿ����� Ȯ���غ�����");
		}
	}

	@Override
	public void oneSearchStd() {
		// �л� ��ȸ
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudentBean> list = new ArrayList<StudentBean>();
		String sql = "SELECT * FROM STUDENT ";

		try {
			System.out.println("� ������� �л��� ��ȸ�Ͻðڽ��ϱ�?");
			System.out.println("1.����  2.�й�  3.�̸�");
			switch (scan.nextLine()) {
			case "1":
				// �������� ��ȸ
				sql += "WHERE SID = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("�л��� ������ �Է� : ");
				pstmt.setInt(1, Integer.parseInt(scan.nextLine()));
				break;
			case "2":
				// �й����� ��ȸ
				sql += "WHERE NUM = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("�л��� �й��� �Է� : ");
				pstmt.setInt(1, Integer.parseInt(scan.nextLine()));
				break;
			case "3":
				// �̸����� ��ȸ
				sql += "WHERE NAME = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("�л��� �̸��� �Է� : ");
				pstmt.setString(1, scan.nextLine());
				break;

			default:
				break;
			}
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}

			if (list.size() == 0)
				System.out.println("�ش� �л��� ��ȸ�� ���� �ʽ��ϴ�.");
			for (StudentBean sb : list)
				System.out.println(sb);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db�� ������ �� �Ǿ����� Ȯ���غ�����");
		}

	}

	@Override
	public void updateStd() {
		// �л� ����
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT ";
		sql += "SET name = ?, age = ?, num = ?, major = ? ";
		sql += "WHERE sid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("�����Ͻ� �л��� ������ �Է� : ");
			pstmt.setInt(5, Integer.parseInt(scan.nextLine()));
			System.out.print("�̸��� �Է� : ");
			pstmt.setString(1, scan.nextLine());
			System.out.print("���̸� �Է� : ");
			pstmt.setInt(2, Integer.parseInt(scan.nextLine()));
			System.out.print("�й��� �Է� : ");
			pstmt.setInt(3, Integer.parseInt(scan.nextLine()));
			System.out.print("�а��� �Է� : ");
			pstmt.setString(4, scan.nextLine());

			int result = pstmt.executeUpdate();

			if (result < 0)
				System.out.println("�л����� ������ �����Ͽ����ϴ�.");
			else if (result > 0)
				System.out.println("�л����� ���� ����!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db�� ������ �� �Ǿ����� Ȯ���غ�����");
		}
	}

	@Override
	public void deleteStd() {
		// �л� ����
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM STUDENT ";
		   sql += "WHERE sid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("�����Ͻ� �л��� ������ �Է� : ");
			pstmt.setString(1, scan.nextLine());
			
			int result = pstmt.executeUpdate();
			
			if(result < 0)
				System.out.println("�л����� ������ �����Ͽ����ϴ�.");
			else if(result > 0)
				System.out.println("�л����� ���� ����!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db�� ������ �� �Ǿ����� Ȯ���غ�����");
		}
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
