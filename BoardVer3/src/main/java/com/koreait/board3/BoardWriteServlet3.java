package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.utils.BoardDAO;
import com.koreait.utils.BoardVO3;
import com.koreait.utils.MyUtils;

@WebServlet("/write3")
public class BoardWriteServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("write3", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt =request.getParameter("ctnt");
		
		System.out.println(title+" "+ctnt);
		
		BoardVO3 vo3 = new BoardVO3();
		vo3.setTitle(title);
		vo3.setCtnt(ctnt);
		
		BoardDAO.insertBoard(vo3);
		
		response.sendRedirect("/list3");
	}
}
