/**
 * 학생 조회
 * (순번 or 학번 or 이름으로)
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
			System.out.println("연결완료");
			
			System.out.println("어떤 방식으로 학생을 조회하시겠습니까?");
			System.out.println("1.순번  2.학번  3.이름");
			String sql = "";
			switch (scan.nextLine()) {
			case "1":
				//순번으로 조회
				sql = "SELECT * FROM STUDENT ";
				sql += "WHERE SID = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("학생의 순번을 입력 : ");
				pstmt.setInt(1, Integer.parseInt(scan.nextLine()));
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
				}
				if(list.size() == 0)
					System.out.println("해당 학생은 조회가 되지 않습니다.");
				for(StudentBean sb : list)
					System.out.println(sb);
				break;
			case "2":
				//학번으로 조회
				sql = "SELECT * FROM STUDENT ";
				sql += "WHERE NUM = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("학생의 학번을 입력 : ");
				pstmt.setInt(1, Integer.parseInt(scan.nextLine()));
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
				}
				
				if(list.size() == 0)
					System.out.println("해당 학생은 조회가 되지 않습니다.");
				for(StudentBean sb : list)
					System.out.println(sb);
				break;
			case "3":
				//이름으로 조회
				sql = "SELECT * FROM STUDENT ";
				sql += "WHERE NAME = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.print("학생의 이름을 입력 : ");
				pstmt.setString(1, scan.nextLine());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
				}
				
				if(list.size() == 0)
					System.out.println("해당 학생은 조회가 되지 않습니다.");
				for(StudentBean sb : list)
					System.out.println(sb);
				break;
				
			default:
				break;
			}
			
			
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
			System.out.println("드라이버가 존재하지 않습니다.");
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			System.out.println("에러 : ");
		} finally {
			try {
				conn.close();
				System.out.println("연결 종료");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	scan.close();	
	}
	
}
