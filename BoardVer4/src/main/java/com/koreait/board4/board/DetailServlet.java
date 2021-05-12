package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		UserVO user = (UserVO)request.getSession().getAttribute("loginUser");
		if(user==null) {
			response.sendRedirect("/user/login");
			return;
		}*/
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO vo = BoardDAO.selBoard(iboard);
		request.setAttribute("vo", vo);
		MyUtils.openJSP("board/detail", request, response);
	}

}
