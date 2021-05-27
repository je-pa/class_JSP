package com.koreait.board7.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board7.DBUtils;

public class UserDAO {
	//아이디가 있으면 1 없으면 0
	public static int selIdChk(String uid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		String sql = "SELECT iuser FROM t_user WHERE uid=?";
		try {
			con = DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, uid.trim());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}
	public static UserEntity selUser(UserEntity param) {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		UserEntity result = null;
		String sql = "SELECT iuser, uid, upw, unm,profileImg FROM t_user WHERE uid=?";
		try {
			con= DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs=ps.executeQuery();
			if(rs.next()) {
				result=new UserEntity();
				result.setIuser(rs.getInt("iuser"));
				result.setUid(rs.getString("uid"));
				result.setUpw(rs.getString("upw"));
				result.setUnm(rs.getString("unm"));
				result.setProfileImg(rs.getString("profileImg"));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
}
