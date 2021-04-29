<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail</h1>
	<div>${vo.title}</div>
	<div>${vo.ctnt}</div>
	<form action="/del" method="post">
		<input type="hidden" name="no" value="${param.no}">
		<input type="submit" value="삭제">
		<button>삭제</button>
		<a href="/mod?no=${param.no}"><input type="button" value="수정"></a>
	</form>
	
</body>
</html>