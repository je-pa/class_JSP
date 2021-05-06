package com.kita.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kita.comment.ComDAO;
import com.kita.comment.ComVO;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard=request.getParameter("iboard");
		BoardDAO.updBoardCount(Integer.parseInt(iboard));
		BoardVO boardVo = BoardDAO.selBoard(Integer.parseInt(iboard));
		List<ComVO> comList = ComDAO.selCom(Integer.parseInt(iboard)); 
		
		request.setAttribute("boardVo", boardVo);
		request.setAttribute("comList", comList);
		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
