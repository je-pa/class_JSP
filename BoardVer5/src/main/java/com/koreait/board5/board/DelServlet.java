package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/del")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO param = new BoardVO();
		param.setIboard(MyUtils.getParamInt("iboard", request));
		BoardVO vo = BoardDAO.selBoard(param);
		if(MyUtils.getLoginUser(request)==null) {
			response.sendRedirect("/user/login");
			return;
		}
		if(MyUtils.getLoginUserPK(request)!=vo.getIuser()) {
			response.sendRedirect("/board/detail");
			return;
		}
		BoardDAO.delBoard(MyUtils.getParamInt("iboard", request));
		response.sendRedirect("list");
	}
}
