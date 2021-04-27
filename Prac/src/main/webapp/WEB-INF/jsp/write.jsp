<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action ="/write" method="post">
		<div><input type="text" name="title"></div>
		<div><textarea name="ctnt" rows ="10" cols="10"></textarea></div>
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>