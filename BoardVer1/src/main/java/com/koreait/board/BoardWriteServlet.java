package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp="/WEB-INF/jsp/write.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");//클라이언트에서 넘어오는 값들은 무조건 겟파라미터
		String ctnt = request.getParameter("ctnt");
		
		BoardVO vo= new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		//왼쪽에 title 오른쪽에 ctnt
		
		Database.list.add(vo);//우리가 만든 클래스(BoardO 객체 리스트)
		
		//Database.insert(title, ctnt); 이것도 가능은 함
		
		response.sendRedirect("/list");//get방식으로 주소 이동
	}

}
