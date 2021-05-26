package com.koreait.board7.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class BoardCmtDAO {
	public static int insBoardCmt(BoardCmtEntity param) {
		int result =0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql ="INSERT INTO t_board_cmt (iboard,iuser,cmt) "
				+ " VALUES (?,?,?)";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		return result;
	}
	public static List<BoardCmtDomain> selBoardCmtList(BoardCmtEntity param){
		List<BoardCmtDomain> list=new ArrayList<BoardCmtDomain>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql="SELECT a.icmt,a.cmt, a.regdate, b.iuser, b.unm AS writerNm FROM t_board_cmt a "
				+ " INNER JOIN t_user b ON a.iuser = b.iuser where a.iboard=? order by a.icmt asc";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardCmtDomain vo= new BoardCmtDomain();
				list.add(vo);
				vo.setIcmt(rs.getInt("icmt"));
				vo.setCmt(rs.getString("cmt"));
				vo.setRegdata(rs.getString("regdate"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setWriterNm(rs.getString("writerNm"));
				vo.setIboard(param.getIboard());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps,rs);
		}
		return list;
	}
	public static int delBoardCmt(BoardCmtEntity param) {
		int result =0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql="DELETE FROM t_board_cmt WHERE icmt=? AND iuser=?";
		
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, param.getIcmt());
			ps.setInt(2, param.getIuser());
			
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		return result;
	}
}
