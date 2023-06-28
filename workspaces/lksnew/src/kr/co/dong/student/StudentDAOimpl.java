package kr.co.dong.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static kr.co.dong.good.JDBCTemplate.*;

public class StudentDAOimpl implements StudentDAO{
	Connection conn = getConnection();

	@Override
	public List<StudentBean> listAll() {
		// 전체 조회
		List<StudentBean> list = new ArrayList<StudentBean>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM testdb.student";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insert(StudentBean sb) {
		// 학생 추가
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			String sql = "INSERT INTO testdb.student ";
				   sql += "(name, age, num, major) ";
				   sql += "VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sb.getName());
			pstmt.setInt(2, sb.getAge());
			pstmt.setInt(3, sb.getNum());
			pstmt.setString(4, sb.getMajor());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public StudentBean selectOne(int sid) {
		// 학생 순번으로 조회
		Statement stmt = null;
		ResultSet rs = null;
		StudentBean sb = null;
		
		try {
			String sql = "SELECT * FROM testdb.student ";
				   sql += "WHERE sid = "+sid;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				sb = new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb;
	}

	@Override
	public List<StudentBean> selectOne(String name) {
		// 학생 이름으로 조회
		Statement stmt = null;
		ResultSet rs = null;
		List<StudentBean> list = new ArrayList<StudentBean>();
		
		try {
			String sql = "SELECT * FROM testdb.student ";
				   sql += "WHERE name like '%"+name+"%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new StudentBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int update(StudentBean sb) {
		// 학생 정보 수정
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			String sql = "UPDATE testdb.student ";
				   sql += "SET name = ?, age = ?, num = ?, major = ?";
				   sql += "WHERE sid = " +sb.getSid();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sb.getName());
			pstmt.setInt(2, sb.getAge());
			pstmt.setInt(3, sb.getNum());
			pstmt.setString(4, sb.getMajor());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(int sid) {
		// 학생 정보 삭제
		Statement stmt = null;
		int result = -1;
		try {
			String sql = "DELETE FROM testdb.student ";
				   sql += "WHERE sid = "+ sid;
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
