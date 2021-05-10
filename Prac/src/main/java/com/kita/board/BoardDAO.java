package com.kita.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	
	 public static List<BoardVO> selBoardList(){
		 List<BoardVO> list = new ArrayList<BoardVO>();
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 String sql = "SELECT iboard, title, regdt,boardCount FROM p_board ORDER BY iboard DESC";
		 try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setBoardCount(rs.getInt("boardCount"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(con, ps, rs);
		}
		 
		 return list;
	 }
	
	 
	 public static BoardVO selBoard(int iboard) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 String sql = "SELECT * FROM p_board WHERE iboard=?";
		 
		 try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				//vo.setIboard(iboard);
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(con, ps, rs);
		}
		return null;
		 
	 }
	 
	 public static int insertBoard(BoardVO vo) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 String sql = "INSERT INTO p_board (title, ctnt) VALUES (?,?)";
		 
		 try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(con, ps);
		}
		return 0;
		 
	 }
	 
	 public static int delBoard(BoardVO vo) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 String sql = "DELETE FROM p_board WHERE iboard=?";
		 
		 try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(con, ps);
		}
		return 0;
		 
	 }
	 
	 public static int updBoard(BoardVO vo) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 String sql = "UPDATE p_board SET title=?,ctnt=? WHERE iboard=?";
		 
		 try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(con, ps);
		}
		return 0;
	 }
	 
	 public static int updBoardCount(int iboard) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 String sql = "UPDATE p_board SET boardCount=boardCount+1 WHERE iboard=?";
		 
		 try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, iboard);
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(con, ps);
		}
		return 0;
	 }
}
