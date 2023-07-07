package kr.co.dong.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.a.TimeTrackingPacketReader;

import static kr.co.dong.board.JDBCTemplete.*;

public class BoardDAOimpl implements BoardDAO{
	Connection conn = getConnection();
	Scanner scan = new Scanner(System.in);
	
	@Override
	public List<BoardBean> listAll() {
		// 글 전체 목록 조회
		List<BoardBean> list = new ArrayList<BoardBean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM mydb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BoardBean(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getTimestamp(4).toLocalDateTime(), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insert(BoardBean bb) {
		// 글 작성
		PreparedStatement pstmt = null;
		LocalDateTime ldt = null;
		int result = -1;
		try {
			String sql = "INSERT into mydb.article ";
				   sql += "(title, content, createdAt, createdBy) ";
				   sql += "VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bb.getTitle());
			pstmt.setString(2, bb.getContent());
			ldt = LocalDateTime.now();
			pstmt.setTimestamp(3, Timestamp.valueOf(ldt));
			System.out.println("createdBy : ");
			pstmt.setString(4, bb.getCreatedBy());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public BoardBean selectOne(int bid) {
		// 글 번호로 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean bb = null;
		LocalDateTime time = LocalDateTime.now();
		try {
			String sql = "SELECT * FROM mydb.article ";
				   sql += "WHERE bid = " + bid;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bb = new BoardBean(rs.getString(1), rs.getString(2), rs.getTimestamp(3).toLocalDateTime(), rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bb;
	}

	@Override
	public List<BoardBean> selectOne(String title) {
		// 글 제목으로 조회
		return null;
	}

	@Override
	public int update(BoardBean bb) {
		// 글 수정
		return 0;
	}

	@Override
	public int delete(int bid) {
		// 글 삭제
		return 0;
	}

}
