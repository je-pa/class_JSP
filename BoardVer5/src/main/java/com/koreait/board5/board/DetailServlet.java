package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;
import com.koreait.board5.cmt.CmtDAO;
import com.koreait.board5.cmt.CmtVO;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO boardParam = new BoardVO();
		int iboard =MyUtils.getParamInt("iboard", request);
		boardParam.setIboard(iboard);
		boardParam.setIuser(MyUtils.getLoginUserPK(request));
		
		request.setAttribute("vo", BoardDAO.selBoard(boardParam));
		request.setAttribute("cmtList", CmtDAO.selCmtList(iboard));
		MyUtils.openJSP("board/detail", request, response);
	}
}
