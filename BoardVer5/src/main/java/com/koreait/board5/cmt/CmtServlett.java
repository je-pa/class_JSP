package com.koreait.board5.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/cmt")
public class CmtServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt = MyUtils.getParamInt("icmt", request);
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPK(request);
		CmtVO param = new CmtVO();
		param.setIcmt(icmt);
		param.setIuser(iuser);
		CmtDAO.delCmt(param);
		
		response.sendRedirect("detail?iboard="+iboard);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.getLoginUser(request)==null) {
			response.sendRedirect("/user/login");
			return;
		}
		int icmt = MyUtils.getParamInt("icmt", request);
		int iboard =MyUtils.getParamInt("iboard",request);
		String cmt =request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPK(request);
		
		CmtVO param =new CmtVO();
		
		param.setCmt(cmt);
		param.setIuser(iuser);
//		System.out.printf("%d, %d, %s", iboard, cmt, iuser);
		if(icmt !=0) {
			param.setIcmt(icmt);
			CmtDAO.updCmt(param);	
		} else {
			param.setIboard(iboard);
			CmtDAO.insCmt(param);
		}
		response.sendRedirect("detail?iboard="+ iboard);
	}
}
