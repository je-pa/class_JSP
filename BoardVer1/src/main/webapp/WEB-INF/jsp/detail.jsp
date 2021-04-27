<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.koreait.board.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String no = request.getParameter("no");
		BoardVO vo = (BoardVO) request.getAttribute("data");
	%>
	<h1>Detail<%=no %></h1>
	<div><%request.getParameter("no"); %></div>
	<div>
		<form action="/del" method="post">
			<input type = "hidden" name="no" value="<%=no%>">
			<input type="submit" value="삭제">
		</form>
		<a href ="/mod?no=<%=no %>"><button>수정</button></a>
		
	</div>
	<div>제목 : <%=vo.getTitle() %></div>
	<div> <%=vo.getCtnt() %></div>
</body>
</html>