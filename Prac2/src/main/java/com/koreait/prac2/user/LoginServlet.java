package com.koreait.prac2.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.prac2.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.getLoginUser(request)!=null){
			response.sendRedirect("/board/list");
			return;
		}
		MyUtils.openJSP("/user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO vo = new UserVO();
		vo.setUid(request.getParameter("uid"));
		vo.setUpw(request.getParameter("upw"));
		int result = UserDAO.loginUser(vo);
		if(result==1){
			vo.setUpw(null);
			request.getSession().setAttribute("loginUser", vo);
			response.sendRedirect("/board/list");
			return;
		}
		String errMsg ="오류가 있다!!!!!";
		switch(result) {
		case 2:
			errMsg="아이디가 없다!!!!";
			break;
		case 3:
			errMsg="비밀번호가 틀렸다!!!!";
		}
		request.setAttribute("errMsg", errMsg);
		
		doGet(request, response);
	}

}
