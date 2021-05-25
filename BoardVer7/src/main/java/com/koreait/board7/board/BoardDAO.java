package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.koreait.board7.DBUtils;

public class BoardDAO {
	public static int selPagingCnt(BoardDTO param) {
		int result=0;
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT CEIL(COUNT(iboard)/?)")
		.append("FROM t_board a")
		.append(" INNER JOIN t_user B ")
		.append(" ON a.iuser = b.iuser");
		
		if(param.getSearchType()>0) {
			sb.append(" WHERE ");
		}
		switch(param.getSearchType()) {
		case 1:
			sb.append("a.title LIKE '%")
			.append(param.getSearchText())
			.append("%'OR a.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 2:
			sb.append("a.title LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 3:
			sb.append("a.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 4:
			sb.append("b.unm LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		}
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sb.toString());
			ps.setInt(1, param.getRecordCnt());
			rs=ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);//첫번째 컬럼
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	public static List<BoardDomain> selBoardList(BoardDTO param){
		List<BoardDomain> list = new ArrayList();
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String sql = "SELECT a.iboard, a.title, a.iuser, a.regdt ,b.unm as writeNm "
				+ " FROM t_board a INNER JOIN t_user b ON a.iuser=b.iuser";
		switch(param.getSearchType()) {
		case 1://제목+내용
			sql+=String.format(" WHERE a.title LIKE '%%%s%%' OR A.ctnt LIKE '%%%s%%'"
					, param.getSearchText(),param.getSearchText());
			break;
		case 2 ://제
			sql+=String.format(" WHERE a.title LIKE '%%%s%%' "
					, param.getSearchText());
			break;
			
		case 3://내
			sql+=String.format(" WHERE a.ctnt LIKE '%%%s%%' "
					, param.getSearchText());
			break;
		case 4://글쓴이
			sql+=String.format(" WHERE b.unm LIKE '%%%s%%' "
					, param.getSearchText());
			break;
		}
			sql+= " ORDER BY iboard DESC LIMIT ?,?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardDomain vo=new BoardDomain();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setWriterNm(rs.getString("writeNm"));
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
	
	public static BoardDomain selBoard(BoardDTO param){
		BoardDomain result = null;
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		String sql = "SELECT a.title, a.iuser, a.regdt ,a.ctnt, b.unm as writeNm "
				+ " FROM t_board a INNER JOIN t_user b ON a.iuser=b.iuser"
				+ " WHERE a.iboard=?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, param.getIbaord());
			rs=ps.executeQuery();
			if(rs.next()) {
				result=new BoardDomain();
				result.setIboard(param.getIbaord());
				result.setTitle(rs.getString("title"));
				result.setCtnt(rs.getString("ctnt"));
				result.setIuser(rs.getInt("iuser"));
				result.setRegdt(rs.getString("regdt"));
				result.setWriterNm(rs.getString("writeNm"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
}
