<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mission1</title>
</head>
<body>
	<div>스크립틀릿 이해를 하였는가 그 첫번째</div>
	<div>for문을 이용하여 1~10 세로방향으로 찍히도록 해줘</div>
	<div>각 숫자들은 div로 감싸라</div>


<%
	for(int i=1;i<=10;i++){
		out.print("<div>");
		out.print(i); //30
		out.print("</div>");	
	}
%>
<%for(int i=1;i<=10;i++){ %>
	<div><%=i %></div>
<%} %>
</body>
</html>  