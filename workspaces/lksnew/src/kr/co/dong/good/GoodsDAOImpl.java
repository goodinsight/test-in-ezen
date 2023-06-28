package kr.co.dong.good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static kr.co.dong.good.JDBCTemplate.*;

public class GoodsDAOImpl implements GoodsDAO{
//	JDBC ����
	Connection conn = getConnection();
	Scanner scan = new Scanner(System.in);
	
	@Override
	public List<GoodsBean> listAll() {
		// ��ǰ ��ü ���
		Statement stmt = null;
		ResultSet rs = null;
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		
		try {
			String sql = "SELECT * FROM testdb.goods";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new GoodsBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close(stmt);
		close(rs);
		return list;
	}

	@Override
	public int insert(GoodsBean gb) {
		// ��ǰ �߰�
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			String sql = "INSERT INTO testdb.goods (gname, gcontent, gcnt, getc) ";
			sql += "VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gb.getGname());
			pstmt.setString(2, gb.getGcontent());
			pstmt.setInt(3, gb.getGcnt());
			pstmt.setString(4, gb.getGetc());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}

	@Override
	public GoodsBean selectOne(int gid) {
		// ��ǰ ��ȸ(��ǰ��ȣ)
		Statement stmt = null;
		ResultSet rs = null;
		GoodsBean gb = null;
		
		try {
			String sql = "SELECT * FROM testdb.goods ";
				   sql += "WHERE gid = "+gid;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				gb = new GoodsBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(stmt);
		close(rs);
		return gb;
	}

	@Override
	public List<GoodsBean> selectOne(String gname) {
		// ��ǰ ��ȸ(��ǰ��)
		Statement stmt = null;
		ResultSet rs = null;
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		
		try {
			String sql = "SELECT * FROM testdb.goods ";
				   sql += "WHERE gname like '%"+gname+"%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new GoodsBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(stmt);
		close(rs);
		return list;
	}

	@Override
	public int update(GoodsBean gb) {
		// ��ǰ ����
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			String sql = "UPDATE testdb.goods ";
				   sql += "SET gname = ?, gcontent = ?, gcnt = ?, getc = ?";
				   sql += "WHERE gid = " +gb.getGid();
			pstmt = conn.prepareStatement(sql);
			System.out.println("gname�� �Է� : ");
			pstmt.setString(1, scan.nextLine());
			System.out.println("gcontent�� �Է� : ");
			pstmt.setString(2, scan.nextLine());
			System.out.println("gcnt�� �Է� : ");
			pstmt.setInt(3, Integer.parseInt(scan.nextLine()));
			System.out.println("getc�� �Է� : ");
			pstmt.setString(4, scan.nextLine());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}

	@Override
	public int delete(int gid) {
		// ��ǰ ����
		Statement stmt = null;
		int result = -1;
		try {
			String sql = "DELETE FROM testdb.goods ";
				   sql += "WHERE gid = " + gid;
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(stmt);
		return result;
	}

}
