package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		UserVO loginUser =  (UserVO)hs.getAttribute("loginUser");
		if(loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		MyUtils.openJSP("board/write", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iuser = MyUtils.getLoginUserPK(request);
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setCtnt(request.getParameter("ctnt"));
		vo.setIuser(((UserVO)request.getSession().getAttribute("loginUser")).getIuser());
		
		BoardDAO.insertBoard(vo);
		
		response.sendRedirect("list");
	}
}
