package com.koreait.board7.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;

@WebServlet("/board/cmtDelUpd")
public class BoardCmtDelUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//댓글 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPK(request);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIcmt(icmt);
		param.setIuser(iuser);
		
		int result = BoardCmtDAO.delBoardCmt(param);
		System.out.println(" dd "+result);
		response.setCharacterEncoding("UTF-8");
		response.getWriter()
		.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}")
		.flush();
	}
	//댓글 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt=MyUtils.getParamInt("icmt", request);
		String cmt =request.getParameter("cmt");
		
		System.out.println("icmt:"+icmt);
		System.out.println("cmt:"+cmt);
		BoardCmtEntity param = new BoardCmtEntity();
		param.setCmt(cmt);
		param.setIcmt(icmt);
		param.setIuser(MyUtils.getLoginUserPK(request));
		int result = BoardCmtDAO.updBoardCmt(param);
		response.setCharacterEncoding("UTF-8");
		response.getWriter()
		.append("{\"result\":")
		.append(String.valueOf(result))
		.append("}");
	}

}
