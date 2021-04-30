package com.koreait.board3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list3")
public class BoardListServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO3> list= BoardDAO.selBoardList(); 
		//파라미터가 없다는 것은 다 델고 오겠다 범위를 지정하지 않겠다.
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("/WEB-INF/view/list3.jsp").forward(request, response);
	}

}
