package com.kita.board;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardDAO {
	
	public static int insertBoard(BoardVO vo) {
		Connection con=null;
		PreparedStatement ps=null;
		
		String sql = "INSERT INTO p_board (title,ctnt) VALUES (?,?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	public static int delBoard(BoardVO vo) {
		Connection con=null;
		PreparedStatement ps=null;
		
		String sql = "DELETE FROM p_board WHERE iboard=?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, vo.getIboard());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	public static int updBoard(BoardVO vo) {
		Connection con=null;
		PreparedStatement ps=null;
		
		String sql = "UPDATE p_board SET title=?, ctnt=? WHERE iboard=?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
