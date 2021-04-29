package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;

//Data Access Object (DB담당)
//VO는 값만 담는것
//DAO는 DB에 실제로 반영
public class BoardDAO {
	//글등록
	public static int insertBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps =null;
		
		String sql=" INSERT INTO t_board (title,ctnt) "
				+ " values (?,?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);//준비하라@!
			ps.setString(1, vo.getTitle());//string!!
			//ps.setInt(1, 1);//쿼리문을 완성시켜줄거다
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
}
