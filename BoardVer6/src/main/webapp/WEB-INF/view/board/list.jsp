<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>List </h1>
<div>
	<form action="list" method="get">
		<div>
			<input type="search" name="search">
			<input type="submit" value="검색">
		</div>
	</form>
</div>
<table>
	<tr><th>no</th><th>title</th><th>작성자</th><th>작성일</th></tr>
	<c:forEach var="item" items="${requestScope.list }">
		<tr class = "record" onclick = "moveToDetail(${item.iboard})">	
			<td>${pageScope.item.iboard}</td>
			<td>${item.title}</td>
			<td>${item.unm}</td>
			<td>${item.regdt}</td>
		</tr>		
	</c:forEach>
</table>
<div>
	<c:forEach begin="1" end="${requestScope.totalPage}" var="cnt">
		<a href="list?page=${cnt}&search=${param.search}"><span>${cnt}</span></a>
	</c:forEach>
	
</div>