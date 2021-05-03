<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="/write" method="post">
		<div><input type="text" name="title"></div>
		<div><textarea rows="10" cols="10" name = "ctnt"></textarea></div>
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>