package com.koreait.prac2.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.prac2.DBUtils;

public class UserDAO {
	public static int insertUser(UserVO vo) {
		Connection con =null;
		PreparedStatement ps=null;
		String sql="INSERT INTO p_user (unm,uid,upw,gender) VALUES (?,?,?,?)";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getUnm());
			ps.setString(2, vo.getUid());
			ps.setString(3, vo.getUpw());
			ps.setInt(4, vo.getGender());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	public static int loginUser(UserVO param) {
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="SELECT uid, upw, iuser, unm FROM p_user WHERE uid=?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				if(BCrypt.checkpw(param.getUpw(), rs.getString("upw"))) {
					param.setIuser(rs.getInt("iuser"));
					param.setUnm(rs.getString("unm"));
					return 1;
				}return 3;
			}
			return 2;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			DBUtils.close(con, ps, rs);
		}
	}
}
