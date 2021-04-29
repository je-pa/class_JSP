<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/write" method="post">
		<input type="text" name="title">
		<div><textarea name="ctnt" cols="10" rows="10"></textarea></div>
		<div><input type="submit" value="글쓰기완료"></div>
	</form>
</body>
</html>