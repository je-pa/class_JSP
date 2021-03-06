<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <link rel="stylesheet" href="/res/css/boardList.css">
<h1>리스트</h1>
<table>
	<tr><th>no</th><th>title</th><th>작성자</th><th>작성일</th></tr>
	
	<c:forEach var="item" items="${requestScope.list }">
		<tr class = "record" onclick = "moveToDetail(${item.iboard})">	
			<td>${pageScope.item.iboard}</td>
			<td>
				<c:choose>
					<c:when test="${param.searchType eq 1 || param.searchType eq 2 }">
						${item.title.replace(param.searchText,'<mark>'+=param.searchText+='</mark>')}
					</c:when>	
					<c:otherwise>
						${item.title}
					</c:otherwise>				
				</c:choose>

			</td>
			<c:choose>
				<c:when test="${empty item.profileImg }">
					<c:set var="img" value="/res/img/noprofile.jpg"/>
				</c:when>
				<c:otherwise>
					<c:set var="img" value="/res/img/user/${item.iuser }/${item.profileImg }"/>
				</c:otherwise>
			</c:choose>
			<td>
				<c:choose>
					<c:when test="${param.searchType eq 4}">
						${item.writerNm.replace(param.searchText,'<mark>'+=param.searchText+='</mark>')}
					</c:when>
					<c:otherwise>
						${item.writerNm}
					</c:otherwise>
				</c:choose>
				<img src ="${img}" class="profileImg">
			</td>
			<td>${item.regdt}</td>
		</tr>		
	</c:forEach>
</table>
	<c:forEach begin="1" end="${requestScope.paginCnt}" var="page">
		<c:choose>
			<c:when test="${page eq param.cPage || (empty param.cPage && page eq 1)}">
				<span class="colorRed">${page}</span>
			</c:when>
			<c:otherwise>
					<span><a href="list?cPage=${page}&searchType=${param.searchType}&searchText=${param.searchText}">${page}</a></span>
			</c:otherwise>
		</c:choose>
	</c:forEach>
<div>
	<form action="list" method="get">
		<div>
			<select name="searchType">
				<option value="1"${param.searchType==1?'selected':''}>제목+내용</option>
				<option value="2"${param.searchType==2?'selected':''}>제목</option>
				<option value="3"${param.searchType==3?'selected':''}>내용</option>
				<option value="4"${param.searchType==4?'selected':''}>글쓴이</option>
			</select>
			<input type="search" name="searchText">
			<input type="submit" value="검색">
		</div>
	</form>
</div>
<script src="/res/js/boardList.js"></script>