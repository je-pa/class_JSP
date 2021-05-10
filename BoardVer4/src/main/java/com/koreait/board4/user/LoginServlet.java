package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/login",request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String upw=request.getParameter("upw");
		
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);
		
		int result = UserDAO.loginUser(vo);
		System.out.println("r = "+result);
		switch(result) {
		case 1:
			response.sendRedirect("/board/list");
			break;
		default:
			//둘다 로그인을 띄우긴함
			doGet(request, response);
				//(request, response)값이 같아서 연결이 이어짐
			//response.sendRedirect("login?err="+result); 
				//화면을 새로 띄어서 (request, response)값이 다름
			break;
		}
	}

}
