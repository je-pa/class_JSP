<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정</h1>
	<form action="mod" method="post">
		<div><input type="text" name="title" value="${vo.title}"></div>
		<div><textarea name="ctnt">${vo.title}</textarea></div>
		<div>
			<input type="submit" value="글쓰기">
			<input type="reset" value="초기화">
			<input type="hidden" name="iboard" value="${param.iboard }">
		</div>
	</form>
</body>
</html>