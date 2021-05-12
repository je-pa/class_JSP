<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>로그인 성공</div>
	<div>
		${loginUser.unm }님 (${loginUser.uid })환영합니다
		<a href="/user/logout">Logout</a>
	</div>
	<div>
		<a href="write"><button>글쓰기</button></a>
	</div>
	<h1>리스트</h1>
	<div>
		<table>
			<tr><th>num</th><th>title</th><th>작성자</th><th>작성일</th></tr>
			<c:forEach var="item" items="${list}">
				<tr onclick="moveToDetail(${item.iboard})">
					<td>${item.iboard }</td>
					<td>${item.title }</td>
					<td>${item.unm }</td>
					<td>${item.regdt }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		function moveToDetail(iboard){
			location.href="/board/detail?iboard="+iboard;
		}
	</script>
</body>
</html>