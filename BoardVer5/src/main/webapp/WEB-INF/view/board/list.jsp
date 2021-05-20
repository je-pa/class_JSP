<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>

<link rel="stylesheet" href="/res/css/boardList.css">
<script defer src="/res/js/boardList.js"></script>
<!-- defer을 적으면 맨밑에 적은 효과가 남 -> 화면먼저 띄우기 -->
</head>
<body>
	<h1>List </h1>
	<c:if test="${not empty loginUser}">
		<a href="/user/logout">로그아웃</a>
		<div>${sessionScope.loginUser.unm}님 안녕하세요</div>
		<hr>
		<a href="write">글쓰기</a>
	</c:if>
	<c:if test="${empty loginUser }">
		<div><a href="/user/login">로그인 페이지로</a></div>
	</c:if>
	
	<table>
		<tr><th>no</th><th>title</th><th>작성자</th><th>작성일</th></tr>
		<c:forEach var="item" items="${requestScope.list }">
			<tr class = "record" onclick = "moveToDetail(${item.iboard})">	
				<td>${pageScope.item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.unm}</td>
				<td>${item.regdt}</td>
			</tr>		
		</c:forEach>
	</table>
	
</body>
</html>