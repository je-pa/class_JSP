package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/mod")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = BoardDAO.selBoard(MyUtils.getParamInt("iboard", request));
		System.out.println(MyUtils.getParamInt("iboard", request));
		if(MyUtils.getLoginUser(request)==null) {
			response.sendRedirect("/user/login");
			return;
		}
		if(MyUtils.getLoginUserPK(request)!=vo.getIuser()) {
			response.sendRedirect("/board/detail");
			return;
		}
		request.setAttribute("vo", vo);
		MyUtils.openJSP("board/mod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.getLoginUser(request)==null) {
			response.sendRedirect("/user/login");
			return;
		}
		if(MyUtils.getLoginUserPK(request)!=BoardDAO.selBoard(MyUtils.getParamInt("iboard", request)).getIuser()) {
			response.sendRedirect("/board/detail");
			return;
		}
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setCtnt(request.getParameter("ctnt"));
		vo.setIboard(MyUtils.getParamInt("iboard", request));
		BoardDAO.updBoard(vo);
		response.sendRedirect("detail?iboard="+request.getParameter("iboard"));
	}
}
