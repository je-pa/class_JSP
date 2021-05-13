package com.koreait.prac2.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.prac2.MyUtils;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", BoardDAO.selBoardList()); 
		request.setAttribute("loginUser",MyUtils.getLoginUser(request) );
		MyUtils.openJSP("board/list", request, response);
	}
}
