<%@page import="com.kita.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	List<BoardVO> list = (List<BoardVO>)(request.getAttribute("data")); %>
	<h1>List</h1>
	<a href="/write">글쓰기</a>
	<table>
		<tr>
			<th>no</th><th>제목</th>
		</tr>
		<% for(int i=0;i<list.size();i++){ 
				BoardVO vo=list.get(i);	
		%>
				<tr>
				 	<td><%=i %></td>
				 	<td><a href = "/detail?no=<%=i%>"><%=vo.getTitle() %></a></td>
				</tr>
		<%} %>
	</table>
</body>
</html>