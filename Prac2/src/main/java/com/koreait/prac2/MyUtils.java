package com.koreait.prac2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.prac2.board.BoardDAO;
import com.koreait.prac2.user.UserVO;

public class MyUtils {
	public static void openJSP(String jsp ,HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/"+jsp+".jsp").forward(req, res);
	}
	public static int stringToInt(String str) {
		return Integer.parseInt(str);
	}
	public static int getIntParam(String key , HttpServletRequest req) {
		return stringToInt(req.getParameter(key));
	}
	public static UserVO getLoginUser(HttpServletRequest req) {
		if(req==null) {	return null;}
		return (UserVO)req.getSession().getAttribute("loginUser");
	}
	public static int getLoginUserPK(HttpServletRequest req) {
		return getLoginUser(req).getIuser();
	}
	/*public static boolean checkLoginUser(String key, HttpServletRequest req) {
		
	}*/
}
