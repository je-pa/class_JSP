package com.koreait.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list") //95p 주소값!!! 주소값에 요청이 들어오면 실행
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter()
		.append("<html>")
		.append("<head><title>안녕</title><meta charset=\"UTF-8\"></head>")
		.append("<body>")
//		.append("Served at: ")
//		.append(request.getContextPath())
		.append("dddd")
		
		.append("</body>")
		.append("</html>");
		//request는 요청정보가 들어있다 
		//respose 응답을 해주면된다\
		
		PrintWriter out = response.getWriter();
		out.print("ddd");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		doGet(request, response);
	}

}
