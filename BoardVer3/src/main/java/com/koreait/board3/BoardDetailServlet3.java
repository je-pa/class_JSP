package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail3")
public class BoardDetailServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		
		BoardVO3 data= BoardDAO.selBoard(Integer.parseInt(iboard));
		
		request.setAttribute("data", data);
		
		
		request.getRequestDispatcher("/WEB-INF/view/detail3.jsp").forward(request, response);
	}
}
