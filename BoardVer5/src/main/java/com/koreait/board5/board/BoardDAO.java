package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;
import com.koreait.board5.user.UserVO;

public class BoardDAO {
	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList<>();
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String sql = "SELECT a.iboard, a.title, a.regdt, b.unm FROM t_board a LEFT JOIN t_user b "
				+ "ON a.iuser = b.iuser";
		try {
			con = DBUtils.getCon();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setUnm(rs.getString("unm"));
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	public static BoardVO selBoard(BoardVO param) {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String sql = "SELECT a.iboard, a.title, a.ctnt, a.regdt, b.unm,a.iuser "
				+ " , IF(c.iboard IS NULL ,0, 1) AS isFav "
				+ " FROM t_board a INNER JOIN t_user b "
				+ " ON a.iuser = b.iuser "
				+ " LEFT JOIN t_board_fav c "
				+ " ON a.iboard = C.iboard AND c.iuser = ? "
				+ " WHERE a.iboard = ?";
		try {
			con = DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, param.getIuser());//로그인 user PK
			ps.setInt(2, param.getIboard());
			rs=ps.executeQuery();
			if(rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setUnm(rs.getString("unm"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setIsFav(rs.getInt("isFav"));
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return null;
	}
	
	public static int insertBoard(BoardVO param) {
		Connection con =null;
		PreparedStatement ps =null;

		String sql = "INSERT INTO t_board (title, ctnt, iuser) VALUES (?,?,?)";
		try {
			con= DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	public static int delBoard(int iboard) {
		Connection con =null;
		PreparedStatement ps =null;

		String sql = "DELETE FROM t_board WHERE iboard=?";
		try {
			con= DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, iboard);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static int updBoard(BoardVO param) {
		Connection con =null;
		PreparedStatement ps =null;

		String sql = "UPDATE t_board SET title=?, ctnt=? WHERE iboard=?";
		try {
			con= DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
