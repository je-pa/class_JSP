<%@page import="com.kita.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기</h1>
	<%
		String no = request.getParameter("no");
		BoardVO vo = (BoardVO)request.getAttribute("data"); 
	%>
	<form action="/del" method="post">
		<div><%=vo.getTitle() %></div>
		<div><%=vo.getCtnt() %></div>
		<input type = "hidden" name="no" value="<%=no%>">
		<input type="submit" value="삭제">
	</form>
	<a href="/mod?no=<%=no%>">수정</a>
</body>
</html>