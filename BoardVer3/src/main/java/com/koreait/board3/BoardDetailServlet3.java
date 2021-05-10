package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.utils.BoardDAO;
import com.koreait.utils.BoardVO3;
import com.koreait.utils.MyUtils;

@WebServlet("/detail3")
public class BoardDetailServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String iboard = request.getParameter("iboard");
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO3 data= BoardDAO.selBoard(iboard);
		
		request.setAttribute("data", data);
		
		MyUtils.openJSP("detail3", request, response);
	}
}
