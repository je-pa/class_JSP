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
	<%	String no=request.getParameter("no"); 
		BoardVO vo = (BoardVO)request.getAttribute("data");
	%>
	<form action ="/mod" method="post">
		<input type="hidden" name ="name" value=no>
		<div><input type="text" name="title" value="<%=vo.getTitle() %>"></div>
		<div><textarea name="ctnt" rows ="10" cols="10"><%=vo.getCtnt() %></textarea></div>
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>