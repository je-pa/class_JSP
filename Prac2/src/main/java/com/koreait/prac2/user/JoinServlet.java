package com.koreait.prac2.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.prac2.MyUtils;

@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO vo = new UserVO();
		vo.setGender(MyUtils.getIntParam("gender", request));
		vo.setUid(request.getParameter("uid"));
		vo.setUpw(BCrypt.hashpw(request.getParameter("upw"),BCrypt.gensalt()));
		vo.setUnm(request.getParameter("unm"));
		UserDAO.insertUser(vo);
		response.sendRedirect("login");
	}

}
