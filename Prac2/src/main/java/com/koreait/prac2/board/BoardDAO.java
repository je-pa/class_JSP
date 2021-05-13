package com.koreait.prac2.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.prac2.DBUtils;

public class BoardDAO {
	public static List<BoardVO> selBoardList(){
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql = "SELECT a.title, a.iboard, a.regdt, b.unm FROM p_board a "
				+ "LEFT JOIN p_user b ON a.iuser=b.iuser";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setTitle(rs.getString("title"));
				vo.setIboard(rs.getInt("iboard"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setUnm(rs.getString("unm"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static BoardVO selBoard(int iboard){
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql = "SELECT a.title, a.iboard,a.ctnt, a.regdt,b.iuser, b.unm FROM p_board a "
				+ "LEFT JOIN p_user b ON a.iuser=b.iuser WHERE a.iboard=?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs=ps.executeQuery();
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setTitle(rs.getString("title"));
				vo.setIboard(rs.getInt("iboard"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	public static int insertBoard(BoardVO vo){
		Connection con = null;
		PreparedStatement ps=null;
		String sql = "INSERT INTO p_board (title,ctnt,iuser)VALUES(?,?,?)";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	public static int delBoard(BoardVO vo){
		Connection con = null;
		PreparedStatement ps=null;
		String sql = "DELETE FROM p_board WHERE iboard=?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
