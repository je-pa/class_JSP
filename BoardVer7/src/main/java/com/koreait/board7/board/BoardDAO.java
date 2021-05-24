package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.koreait.board7.DBUtils;

public class BoardDAO {
	public static List<BoardDomain> selBoardList(){
		List<BoardDomain> list = new ArrayList();
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String sql = "SELECT a.iboard, a.title, a.iuser, a.regdt ,b.unm as writeNM "
				+ " FROM t_board a INNER JOIN t_user b ON a.iuser=b.iuser"
				+ " ORDER BY iboard DESC";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardDomain vo=new BoardDomain();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setWriterNm(rs.getString("writeNM"));
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
}
