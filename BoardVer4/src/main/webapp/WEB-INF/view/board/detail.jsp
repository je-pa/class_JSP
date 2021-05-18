<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title }</title>
</head>
<body>
	<h1>디테일 페이지</h1>
	<div>번호 : ${vo.iboard }</div>
	<div>제목 : ${vo.title}</div>
	<div>작성일 : ${vo.regdt}</div>
	<div>작성자 : ${vo.unm}</div>
	<div>내용 : ${vo.ctnt}</div>
	<c:if test="${loginUser.iuser == vo.iuser }">
		<div>
			<a href="del?iboard=${vo.iboard }">삭제</a>
			<a href="mod?iboard=${vo.iboard }">수정</a>
		</div>
	</c:if>
	<form action="cmt" method="post">
		<textarea name="cmt"></textarea>
		<input type="hidden" name="icmt" value="0">
		<input type="hidden" name="iboard" value="${vo.iboard}">
		<input type="submit" value="댓글등록">
	</form>
	<form action="cmt" method="post" class="hidden">
		<textarea name="cmt"></textarea>
		<input type="hidden" name="icmt" value="0">
		<input type="hidden" name="iboard" value="${vo.iboard}">
		<input type="submit" value="댓글등록">
	</form>
	<table>
		<tr>
			<th>내용</th><th>작성자</th><th>작성일</th><th>비고</th>
		</tr>
		<c:forEach var="item" items="${list }">
			<tr>
				<td>${item.cmt }</td>
				<td>${item.unm }</td>
				<td>${item.regdate }</td>
				<td>
					<c:if test="${loginUser.iuser==item.iuser }">
						<button>수정</button>
						<button>삭제</button>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>