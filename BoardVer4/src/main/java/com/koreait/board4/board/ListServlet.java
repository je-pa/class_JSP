package com.koreait.board4.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser =  (UserVO)hs.getAttribute("loginUser");
		
		//null이면 오류뜨니까 boolean 말고 Boolean사용함
		if(loginUser==null) {
			response.sendRedirect("/user/login");
			return;
		}
		List<BoardVO> list = BoardDAO.selBoardList();
		System.out.println(list);
		request.setAttribute("list", list);
		MyUtils.openJSP("board/list", request, response);
		
	}
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		
		/*System.out.println("req : "+request.toString());
		System.out.println("hs : "+hs.toString());
		Boolean loginSuccess =  (Boolean)hs.getAttribute("loginSuccess");
		System.out.print(loginSuccess);
		//null이면 오류뜨니까 boolean 말고 Boolean사용함
		if(loginSuccess==null||loginSuccess == false) {
			response.sendRedirect("/user/login");
			return;
		}
		
		MyUtils.openJSP("board/list", request, response);
		
	}*/
}
