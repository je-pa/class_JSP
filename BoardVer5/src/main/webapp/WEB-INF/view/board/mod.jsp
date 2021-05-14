<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<form action="mod" method="post">
		<div><input type="text" name="title"value="${vo.title}"></div>
		<div><textarea rows="10" cols="10" name="ctnt">${vo.ctnt}</textarea></div>
		<input type="hidden" name="iboard" value="${param.iboard }">
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>