<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h1>수정</h1>
	<form action="mod" method="post">
		<div><input type="text" name="title" value="${vo.title}"></div>
		<div><textarea rows="10" cols="10" name="ctnt">${vo.ctnt}</textarea></div>
		<input type="hidden" value="${param.iboard }">
		<input type="submit" value="수정하기">
		<input type="reset" value="리셋">
	</form>
</body>
</html>