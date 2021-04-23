<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>나는 사람이다 </div>
	<div>아무생각이 없다 </div>
	<div>근데 존재한다 </div>
	<h1>글쓰기</h1>
	<form action="/write" method="post"><!-- 액션은 델고 갈곳(주소값) 메소드는 get/post방식 -->
		<div>
			제목: <input type="text" name="title">
		</div>
		<div>
			내용: <textarea name="ctnt" rows="10" cols="10"></textarea>
		</div>
		<div>
			<input type="submit" value="글쓰기">
		</div>
	</form>
</body>
</html>