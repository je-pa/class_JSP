package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser =  (UserVO)hs.getAttribute("loginUser");
		
		if(loginUser!=null) {
			response.sendRedirect("/board/list");
			return;
		}
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
		if(result==1) {
			HttpSession hs= request.getSession();
			vo.setUpw(null);
			hs.setAttribute("loginUser", vo);
			//vo가 가리키는 UserVO객체는 (iuser, uid, unm 값만 담고있다.)
			
			response.sendRedirect("/board/list");
			return;
		}
		String errMsg =null;
		switch(result) {
		case 0:
			errMsg="에러가 발생하였습니다";
			break;
		case 2:
			errMsg="아이디가 없습니다";
			break;
		case 3:
			errMsg="비밀번호를 확인해 주세요";
		}
		request.setAttribute("errMsg", errMsg);
		//둘다 로그인을 띄우긴함
		doGet(request, response);
			//(request, response)값이 같아서 연결이 이어짐
		//response.sendRedirect("login?err="+result); 
			//화면을 새로 띄어서 (request, response)값이 다름
	}

}
