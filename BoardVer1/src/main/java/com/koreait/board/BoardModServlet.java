package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		request.setAttribute("data", Database.list.get(Integer.parseInt(no)));
		
		String jsp ="WEB-INF/jsp/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");//클라이언트에서 넘어오는 값들은 무조건 겟파라미터
		String ctnt = request.getParameter("ctnt");
		String no = request.getParameter("no");
		
		BoardVO vo =new BoardVO();
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		Database.list.set(Integer.parseInt(no), vo);
		response.sendRedirect("/detail?no="+no);
	}
}
