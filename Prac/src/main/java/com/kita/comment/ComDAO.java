package com.kita.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.kita.board.DBUtils;

public class ComDAO {
	public static List<ComVO> selCom(int iboard) {
		List<ComVO> list = new ArrayList<ComVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM com_board WHERE iboard=?";
		 
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				ComVO vo = new ComVO();
				//vo.setIboard(iboard);
				vo.setNick(rs.getString("nick"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(con, ps, rs);
		}
		return list;
		 
	 }
	 
	 public static int insertCom(ComVO vo) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 String sql = "INSERT INTO com_board (iboard, nick, ctnt) VALUES (?,?,?)";
		 
		 try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setString(2, vo.getNick());
			ps.setString(3, vo.getCtnt());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(con, ps);
		}
		return 0;
		 
	 }

}
