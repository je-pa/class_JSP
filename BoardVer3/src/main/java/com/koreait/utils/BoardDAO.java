package com.koreait.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Data Access Object (DB담당)
//VO는 값만 담는것
//DAO는 DB에 실제로 반영
public class BoardDAO {
	//글등록
	public static int insertBoard(BoardVO3 vo) {
		Connection con = null;//연결
		PreparedStatement ps =null;
		
		String sql=" INSERT INTO t_board (title,ctnt) "
				+ " values (?,?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);//준비하라@!
			
			ps.setString(1, vo.getTitle());//string!!
			ps.setString(2, vo.getCtnt());
			//ps.setInt(1, 1);//?에 값을 넣어 
			//쿼리문을 완성시켜줄거다
			
			return ps.executeUpdate(); //예도 예외를 던져주기 때문에 그냥 한꺼번에 잡아줌
			//완성된 문장이 실행됨 insert, update, delete
			//int 값이 나옴 : 몇개의 행에 영향을 주었는지 리턴
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
	
	public static int deleteBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps =null;
		
		String sql=" DELETE FROM t_board"
					+ " WHERE iboard=? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);//준비하라@!
			
			ps.setInt(1, vo.getIboard());
			
			return ps.executeUpdate(); //예도 예외를 던져주기 때문에 그냥 한꺼번에 잡아줌
			//완성된 문장이 실행됨 insert, update, delete
			//int 값이 나옴 : 몇개의 행에 영향을 주었는지 리턴
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
	
	public static int updBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps =null;
		
		String sql="UPDATE t_board SET title=?, ctnt=? WHERE iboard=?";
		//UPDATE Reservation SET RoomNum = 2002 WHERE Name = '홍길동';
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);//준비하라@!
			
			ps.setString(1, vo.getTitle());//string!!
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			return ps.executeUpdate(); //예도 예외를 던져주기 때문에 그냥 한꺼번에 잡아줌
			//완성된 문장이 실행됨 insert, update, delete
			//int 값이 나옴 : 몇개의 행에 영향을 주었는지 리턴
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}

	public static List<BoardVO3> selBoardList() {
		List<BoardVO3> list = new ArrayList();
		
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;//select에 필요
		
		String sql = "SELECT iboard, title, regdt FROM t_board "
				+ "ORDER BY iboard DESC";//;하면 해킹위험
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			//ps.toString();
			
			rs = ps.executeQuery();//rs는 sql문의 결과가 저장된다!
							//컨트롤 쉬프트 f9
			
			while(rs.next()) { 
				BoardVO3 vo = new BoardVO3();
				list.add(vo);
				
				int iboard =rs.getInt("iboard");//컬럼명
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static BoardVO3 selBoard(int iboard) {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;//select에 필요
		
		String sql = "SELECT * FROM t_board WHERE iboard = ?";//;하면 해킹위험
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			//ps.toString();
			ps.setInt(1, iboard);
			
			rs = ps.executeQuery();//rs는 sql문의 결과가 저장된다!
							//컨트롤 쉬프트 f9
			if(rs.next()) {
				BoardVO3 vo = new BoardVO3();
				
				iboard =rs.getInt("iboard");//컬럼명
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String ctnt = rs.getString("ctnt");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);	
				vo.setCtnt(ctnt);	
				
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
