<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<input type="text" id="num1" value="123"> <!-- 객체 -->
		<input type="text" id="num2">
		<button onclick="sum();">더하기</button> <!-- 클릭되면 sum 호출 -->
		<button onclick="minus()">빼기</button>
	</div>
	<div>
		<input type="text" id="result">
	</div>
	<script>
		var num1Elem = document.getElementById('num1');
		var num2Elem = document.querySelector('#num2');
		//#:id, .: class
		var resultElem=document.querySelector('#result');
		
		function sum(){
			var num1 =num1Elem.value;
			var num2 =num2Elem.value;
			resultElem.value = parseInt(num1)+Number(num2);
			
			//resultElem.value = '100';
		}
		function minus(){
			var num1 =num1Elem.value;
			var num2 =num2Elem.value;
			resultElem.value = parseInt(num1)-Number(num2);
		}
	</script>
</body>
</html>