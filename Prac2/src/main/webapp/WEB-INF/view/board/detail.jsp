<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<h1>디테일</h1>
	<div>제목 : ${vo.title}</div>
	<div>내용 : ${vo.ctnt}</div>
	<div>작성일 : ${vo.regdt}</div>
	<div>작성자 : ${vo.unm}</div>
	<c:if test="${loginUser.iuser== vo.iuser}">
		<a href="mod">수정</a>
		<a href="del">삭제</a>
	</c:if>
</body>
</html>