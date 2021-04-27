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
	<h1>글수정<%=no %></h1>
	<form action="/mod" method="post"><!-- 액션은 델고 갈곳(주소값) 메소드는 get/post방식 -->
		<input type="hidden" name="no" value="<%=no %>"><!-- 왜넣은거징 -->
		<div>
			제목: <input type="text" name="title" value="<%=vo.getTitle() %>">
		</div>
		<div>
			내용: <textarea name="ctnt" rows="10" cols="10"><%=vo.getCtnt()%></textarea>
		</div>
		<div>
			<input type="submit" value="글수정">
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>