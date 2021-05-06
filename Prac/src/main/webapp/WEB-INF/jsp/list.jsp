<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List</h1>
	<a href="/write">글쓰기</a>
	<table>
		<tr><th>no</th><th>title</th><th>작성일</th></tr>
		<c:forEach var="item" items="${list }">
			<tr onclick = "moveToDetail(${item.iboard})">
				<td>${item.iboard }</td>
				<td>${item.title }</td>
				<td>${item.regdt }</td>
				<td>${item.boardCount}</td>
			</tr>
		</c:forEach>
	</table>
	<script>
		function moveToDetail(iboard){
			location.href="/detail?iboard="+iboard;
		}
	</script>
</body>
</html>