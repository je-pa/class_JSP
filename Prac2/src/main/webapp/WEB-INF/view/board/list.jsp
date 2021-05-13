<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<h1>List</h1>
	
	<c:if test="${not empty loginUser}">
		<a href="/user/logout">로그아웃</a>
		<div>${loginUser.unm}님 안녕하세요</div>
	</c:if>
	<div><a href="write">글쓰기</a></div>
	<table>
		<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
		<c:forEach var="item" items="${list}">
			<tr onclick="moveToDetail(${item.iboard})">
				<td>${item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.unm}</td>
				<td>${item.regdt}</td>
			</tr>
		</c:forEach>
	</table>
	<script>
		function moveToDetail(iboard){
			location.href="/board/detail?iboard="+iboard;
		}
	</script>
</body>
</html>