<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table,th,td{
		border-collapse:collapse;
		border:1px solid black;
	}
</style>
</head>
<body>
	<h1>List</h1>
	<a href="/write">글쓰기</a>
	
	<table>
		<tr><th>no</th><th>title</th></tr>
		<c:forEach var="i" items="${list}" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td><a href="/detail?no=${status.index}">${i.title}</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>