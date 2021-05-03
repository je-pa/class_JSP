package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod3")
public class BoardModServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		BoardVO3 data= BoardDAO.selBoard(Integer.parseInt(iboard));
		request.setAttribute("data", data);
		
		request.getRequestDispatcher("/WEB-INF/view/mod3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String ctnt =request.getParameter("ctnt");
		
		System.out.println(title+" "+ctnt+" "+iboard);
		
		BoardVO3 vo3 = new BoardVO3();
		vo3.setIboard(Integer.parseInt(iboard));
		vo3.setTitle(title);
		vo3.setCtnt(ctnt);
		
		BoardDAO.updBoard(vo3);
		
		response.sendRedirect("/detail3?iboard="+iboard);
	}

}
