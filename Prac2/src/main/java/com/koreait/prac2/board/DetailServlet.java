package com.koreait.prac2.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.prac2.MyUtils;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("vo", BoardDAO.selBoard(MyUtils.getIntParam("iboard", request)));
		MyUtils.openJSP("board/detail", request, response);
	}
}
