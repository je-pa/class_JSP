package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;

public class BoardDAO {
	public static int getAllPage(BoardVO param) {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String sql ="SELECT ceil(COUNT(*)/?) FROM t_board"
				+ " WHERE title LIKE ? ";
		int result=0;
		try {
			con = DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, param.getPage());
			ps.setString(2, "%"+param.getSearch()+"%");
			rs=ps.executeQuery();
			if(rs.next()) { 
				result = rs.getInt(1);//컬럼순서는 1부터시작한다
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	public static List<BoardVO> selBoardList(BoardVO param) {
		List<BoardVO> list = new ArrayList<>();
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String sql = "SELECT a.iboard, a.title, a.regdt, b.unm FROM t_board a LEFT JOIN t_user b "
				+ " ON a.iuser = b.iuser"
				+ " WHERE title LIKE ?"
				+ " ORDER BY iboard DESC"
				+ " LIMIT ?,? ";
		try {
			con = DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+param.getSearch()+"%");
			ps.setInt(2, param.getsIdx());
			ps.setInt(3, param.getPage());
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
}
