package com.koreait.board6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board6.user.UserVO;



public class MyUtils {
	public static UserVO getLoginUser(HttpServletRequest req) {
		if(req==null) {	return null;}
		return (UserVO) req.getSession().getAttribute("loginUser");
	}
	
	public static int getLoginUserPK(HttpServletRequest req) {
		return (getLoginUser(req)).getIuser();
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
	
	public static void openJSP(String title, String fileNm, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/view/"+fileNm+".jsp").forward(request, response);
		req.setAttribute(Const.TITLE,title);
		req.setAttribute(Const.PAGE, fileNm);
		
		String jsp="/WEB-INF/view/template.jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
	}
}