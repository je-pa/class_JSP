package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.getLoginUser(request)==null) {
			response.sendRedirect("/user/login");
			return;
		}
		MyUtils.openJSP("board/write", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.getLoginUser(request)==null) {
			response.sendRedirect("/user/login");
			return;
		}
		BoardVO param = new BoardVO();
		param.setTitle(request.getParameter("title"));
		param.setCtnt(request.getParameter("ctnt"));
		param.setIuser(MyUtils.getLoginUserPK(request));
		BoardDAO.insertBoard(param);
		response.sendRedirect("list");
	}

}
