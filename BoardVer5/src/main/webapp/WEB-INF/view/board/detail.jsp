<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<script defer src="/res/js/boardDetail.js"></script>
</head>
<body>
	<a href="list">리스트로 돌아가기</a>
	<div>제목 : ${vo.title}</div>
	<div>작성자 : ${vo.unm}</div>
	<div>작성일 : ${vo.regdt}</div>
	<div>내용 : ${vo.ctnt}</div>
	<c:if test="${vo.iuser==loginUser.iuser }">
		<a href="del?iboard=${vo.iboard}">삭제</a>
		<a href="mod?iboard=${vo.iboard}">수정</a>
	</c:if>
	<h3>댓글</h3>
	<div>
		<form action="cmt" method="post">
			<input type="hidden" name="iboard" value="${vo.iboard }">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="대글잓성">
			</div>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<c:forEach var="item" items="${requestScope.cmtList }">
				<tr>
					<td>${item.cmt }</td>
					<td>${item.unm }</td>
					<td>${item.regdate }</td>
					<td>
						<c:if test="${sessionScope.loginUser.iuser==item.iuser }">
							<a href=""><button>수정</button></a>
							<button onclick="delCmt(${item.iboard}, ${item.icmt} )">삭제</button>
						</c:if>
					</td>
				</tr>	
			</c:forEach>
		</table>
	</div>
</body>
</html>