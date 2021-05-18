package com.koreait.board5.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class CmtDAO {
	public static void insCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_board_cmt (iboard,iuser,cmt) "
				+ " VALUES (?,?,?) ";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static List<CmtVO> selCmtList(int iboard) {
		List<CmtVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT a.icmt, a.iuser, a.cmt, a.regdate, b.unm "
				+ " FROM t_board_cmt a "
				+ " LEFT JOIN t_user b "
				+ " ON a.iuser=b.iuser "
				+ " WHERE iboard=?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				CmtVO vo = new CmtVO();
				vo.setIboard(iboard);
				vo.setIcmt(rs.getInt("icmt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setCmt(rs.getString("cmt"));
				vo.setRegdate(rs.getString("regdate"));
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

	public static void delCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM t_board_cmt"
				+ " WHERE icmt = ? AND iuser = ? ";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, param.getIcmt());
			ps.setInt(2, param.getIuser());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}

	public static void updCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE t_board_cmt SET cmt = ?"
				+ " WHERE icmt=? AND iuser=?";
		
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, param.getCmt());
			ps.setInt(2, param.getIcmt());
			ps.setInt(3, param.getIuser());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
