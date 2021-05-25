package com.koreait.board7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.user.UserEntity;


public class MyUtils {
	
	public static UserEntity getLoginUser(HttpServletRequest req) {
		if(req==null) {	return null;}
		return (UserEntity) req.getSession().getAttribute("loginUser");
	}
	
	public static int getLoginUserPK(HttpServletRequest req) {
		return (getLoginUser(req)).getIuser();
	}
	
	public static void openJSP(String title, String jsp, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("title", title);
		req.setAttribute("jsp", jsp);
		req.getRequestDispatcher("/WEB-INF/view/template.jsp").forward(req, res);
	}
	
	public static int parseStringToInt(String strNum) {
		try {
			return Integer.parseInt(strNum);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static int getParamInt(String iboard, HttpServletRequest request) {
		/*
		String strVal = request.getParameter(iboard);
		int intNum = parseStringToInt(strVal);
		return intNum;
		*/
		return parseStringToInt(request.getParameter(iboard));
	}
}