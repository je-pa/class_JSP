package com.kita.board;

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
		String no=request.getParameter("no");
		request.setAttribute("vo", Database.list.get(Integer.parseInt(no)));
		request.getRequestDispatcher("/WEB-INF/jsp/mod.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no=request.getParameter("no");
		String title=request.getParameter("title");
		String ctnt=request.getParameter("ctnt");
		
		System.out.println(no);
		BoardVO vo=Database.list.get(Integer.parseInt(no));
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		
		response.sendRedirect("/list");
	}

}
