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
	private String url = ""; // db 주소
	private String user = ""; // db 접속id
	private String password = ""; // db 접속pw
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
			System.out.println("연결완료");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("드라이버가 존재하지 않습니다.");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("에러 : ");
		}
	}

	public void closeConnection() {
		try {
			conn.close();
			System.out.println("접속 종료");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("접속이 정상적으로 종료되지 못했습니다.");
		}
	}

	@Override
	public void insertStd() {
		// 학생 추가
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT ";
		sql += "(sid, name, age, num, major) ";
		sql += "VALUES (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("학생을 추가합니다.");
			System.out.print("순번을 입력 : ");
			pstmt.setInt(1, Integer.parseInt(scan.nextLine()));
			System.out.print("이름을 입력 : ");
			pstmt.setString(2, scan.nextLine());
			System.out.print("나이를 입력 : ");
			pstmt.setInt(3, Integer.parseInt(scan.nextLine()));
			System.out.print("학번을 입력 : ");
			pstmt.setInt(4, Integer.parseInt(scan.nextLine()));
			System.out.print("학과를 입력 : ");
			pstmt.setString(5, scan.nextLine());

			int result = pstmt.executeUpdate();

			if (result < 0)
				System.out.println("학생 추가를 실패하였습니다.");
			else if (result > 0)
				System.out.println("학생 추가 성공!!!");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("에러 : ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db에 접속이 잘 되었는지 확인해보세요");
		}
	}

	@Override
	public void allSearchStd() {
		// 전체 조회
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
			System.out.println("학생정보를 전체조회합니다.");
			for (StudentBean sb : list)
				System.out.println(sb);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db에 접속이 잘 되었는지 확인해보세요");
		}
	}

	@Override
	public void oneSearchStd() {
		// 학생 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudentBean> list = new ArrayList<StudentBean>();
		String sql = "SELECT * FROM STUDENT ";

		try {
			System.out.println("어떤 방식으로 학생을 조회하시겠습니까?");
			System.out.println("1.순번  2.학번  3.이름");
			switch (scan.nextLine()) {
			case "1":
				// 순번으로 조회
				sql += "WHERE SID = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("학생의 순번을 입력 : ");
				pstmt.setInt(1, Integer.parseInt(scan.nextLine()));
				break;
			case "2":
				// 학번으로 조회
				sql += "WHERE NUM = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("학생의 학번을 입력 : ");
				pstmt.setInt(1, Integer.parseInt(scan.nextLine()));
				break;
			case "3":
				// 이름으로 조회
				sql += "WHERE NAME = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("학생의 이름을 입력 : ");
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
				System.out.println("해당 학생은 조회가 되지 않습니다.");
			for (StudentBean sb : list)
				System.out.println(sb);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db에 접속이 잘 되었는지 확인해보세요");
		}

	}

	@Override
	public void updateStd() {
		// 학생 수정
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT ";
		sql += "SET name = ?, age = ?, num = ?, major = ? ";
		sql += "WHERE sid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("수정하실 학생의 순번을 입력 : ");
			pstmt.setInt(5, Integer.parseInt(scan.nextLine()));
			System.out.print("이름을 입력 : ");
			pstmt.setString(1, scan.nextLine());
			System.out.print("나이를 입력 : ");
			pstmt.setInt(2, Integer.parseInt(scan.nextLine()));
			System.out.print("학번을 입력 : ");
			pstmt.setInt(3, Integer.parseInt(scan.nextLine()));
			System.out.print("학과를 입력 : ");
			pstmt.setString(4, scan.nextLine());

			int result = pstmt.executeUpdate();

			if (result < 0)
				System.out.println("학생정보 수정를 실패하였습니다.");
			else if (result > 0)
				System.out.println("학생정보 수정 성공!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db에 접속이 잘 되었는지 확인해보세요");
		}
	}

	@Override
	public void deleteStd() {
		// 학생 삭제
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM STUDENT ";
		   sql += "WHERE sid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("삭제하실 학생의 순번을 입력 : ");
			pstmt.setString(1, scan.nextLine());
			
			int result = pstmt.executeUpdate();
			
			if(result < 0)
				System.out.println("학생정보 삭제를 실패하였습니다.");
			else if(result > 0)
				System.out.println("학생정보 삭제 성공!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db에 접속이 잘 되었는지 확인해보세요");
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
