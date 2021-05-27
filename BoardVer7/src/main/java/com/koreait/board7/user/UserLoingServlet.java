package com.koreait.board7.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board7.MyUtils;

@WebServlet("/user/login")
public class UserLoingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("로그인", "user/userLogin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserEntity vo = new UserEntity();
		vo.setUid(request.getParameter("uid")); 
		UserEntity result = UserDAO.selUser(vo);
		
		if(result==null) {
			request.setAttribute("errMsg","아이디 없음");
		}else if(BCrypt.checkpw(request.getParameter("upw"),result.getUpw()/*암호된게 뒤에로*/ )) {
			result.setUpw(null);
			request.getSession().setAttribute("loginUser", result);
			response.sendRedirect("/board/list");	
			return;
		}else {
			request.setAttribute("errMsg","비밀번호 확인해라");
		}	
		doGet(request,response);
	}
}
