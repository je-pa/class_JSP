package com.koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.DBUtils;

public class BoardDAO {
	public static int insertBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_board (title,ctnt,iuser) VALUES (?,?,?)";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static List<BoardVO> selBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="SELECT a.iboard, a.title, a.regdt, b.unm FROM t_board a "
				+ " LEFT JOIN t_user b ON a.iuser=b.iuser ORDER BY a.iboard DESC";
		try {
			con=DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setUnm(rs.getString("unm"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static BoardVO selBoard(int iboard){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		String sql ="SELECT a.title, a.ctnt, a.regdt,b.iuser, b.unm FROM t_board a "
				+ " LEFT JOIN t_user b ON a.iuser=b.iuser WHERE a.iboard=?";
		try {
			con=DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs=ps.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
			}
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return vo;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	public static int updBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE t_board SET title=?,ctnt=? WHERE iboard =?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	public static int delBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM t_board WHERE iboard =?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
