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
	<h1>Detail</h1>
	<a href="/list">리스트</a>
	<div>
		<a href="/del?iboard=${param.iboard}">삭제</a>
		<a href="/mod?iboard=${param.iboard}">수정</a>
	</div>
	<div>제목:${boardVo.title }</div>
	<div>작성일:${boardVo.regdt}</div>
	<div>내용:${boardVo.ctnt}</div>
	<hr>
	<form action = "/comWrite" method="post">
		<div>닉네임 : <input type="text" name="nick"></div>
		<div>댓글 : <textarea name="com" cols="25"></textarea>
		<input type="hidden" name="iboard" value="${param.iboard }">
		<input type="submit" value="댓글생성"></div>
	</form>
	<table>
		<tr><th>닉네임</th><th>내용</th><th>작성일</th></tr>
		<c:forEach var="item" items="${comList}">
			<tr>
				<td>${item.nick}</td>
				<td>${item.ctnt}</td>
				<td>${item.regdt}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>