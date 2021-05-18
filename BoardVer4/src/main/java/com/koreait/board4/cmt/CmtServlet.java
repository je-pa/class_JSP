package com.koreait.board4.cmt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/board/cmt")
public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//삽입 cmt iuser iboard
		//수정 cmt iuser icmt 
		if(MyUtils.getLoginUser(request)==null) {
			response.sendRedirect("/user/login");
			return;
		}
		CmtVO param = new CmtVO();
		param.setIuser(MyUtils.getLoginUserPK(request));
		param.setCmt(request.getParameter("cmt"));
		int icmt = MyUtils.getParamInt("icmt", request);
		int iboard =MyUtils.getParamInt("iboard", request);
		if(icmt==0) {
			param.setIboard(iboard);
			CmtDAO.insCmt(param);
		}else {
			param.setIcmt(icmt);
			CmtDAO.updCmt(param);
		}
		response.sendRedirect("/board/detail?iboard="+iboard);
	}

}
