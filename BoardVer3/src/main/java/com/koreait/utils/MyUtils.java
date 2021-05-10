package com.koreait.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String jsp,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/"+jsp+".jsp").forward(request, response);
		/*
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		*/
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
