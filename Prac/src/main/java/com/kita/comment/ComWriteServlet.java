package com.kita.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/comWrite")
public class ComWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard= request.getParameter("iboard");
		String nick = request.getParameter("nick");
		String ctnt = request.getParameter("com");
		ComVO com = new ComVO();
		com.setNick(nick);
		com.setCtnt(ctnt);
		com.setIboard(Integer.parseInt(iboard));
		
		ComDAO.insertCom(com);
		
		response.sendRedirect("/detail?iboard="+iboard);
	}

}
