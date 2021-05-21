<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<a href="list">리스트로 돌아가기</a>
	<h1 id="title"></h1>
	<div>번호 : <span id="iboard"></span></div>
	<div>작성자 : <span id="unm"></span></div>
	<div>작성일 : <span id="regdt"></span></div>

	<div id="ctnt"></div>
	
	<script>
		function ajax(iboard){
			console.log('iboard : '+iboard);
			
			const param = { iboard }
			
			const init={
					method:'POST',
					body:new URLSearchParams(param)
			}
			fetch('/board/detail',init)
			.then(function(res){
				return res.json();
			})
			.then(function(myJson){
				console.log(myJson);
				setData(myJson);
			})
		}
		function setData(data){
			var iboardElem = document.querySelector("#iboard");
			var titleElem = document.querySelector("#title");
			var regdtElem = document.querySelector("#regdt");
			var ctntElem = document.querySelector("#ctnt");
			
			iboardElem.innerText = data.iboard;
			titleElem.innerText = data.title;
			regdtElem.innerText = data.regdt;
			ctntElem.innerText = data.ctnt;
		}
		ajax(${param.iboard});
		
	</script>
