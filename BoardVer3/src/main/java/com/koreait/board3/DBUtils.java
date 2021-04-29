package com.koreait.board3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBUtils {
	public static Connection getCon() throws Exception{
		final String DB_NAME = "boardver3";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL="jdbc:mysql://localhost:3308/boardver3";
		final String USER_NAME="root";
		final String PASSWORD ="koreait";
		
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL,USER_NAME, PASSWORD);
		System.out.println("연결성공");
		
		return con;
	}
	public static void close(Connection con, PreparedStatement ps) {
		close(con,ps,null);
	}
	
	public static void close(Connection con, PreparedStatement ps/*쿼리 실행역할*/, ResultSet rs/*실행하고 나오는 결과 담김*/) {
		if(rs!=null) {//con이 ps를, ps가 rs를 만든다 
			try {rs.close();} catch (SQLException e) {e.printStackTrace();	}
		}
		if(ps!=null) {
			try {ps.close();} catch (SQLException e) {e.printStackTrace();	}
		}
		if(con!=null) {
			try {con.close();} catch (SQLException e) {e.printStackTrace();	}
		}
	}
}
