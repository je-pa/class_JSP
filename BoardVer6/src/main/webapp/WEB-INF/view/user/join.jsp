<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<div>
		<a href="login">로그인페이지로 이동</a>
	</div>
	<div>
		<form id="frm">
				<div><input type ="text" name="uid" placeholder="아이디" ></div>
				<div><input type ="password" name="upw" placeholder="비밀번호" ></div>	
				<div><input type="text" name="unm" placeholder="이름"> </div>
				<div>
					<label>여성 <input type="radio" name="gender" value="0" checked></label>
					<label>남성 <input type="radio" name="gender" value="1"></label>
				</div>		
		</form>
	</div>
	<input type="button" value="회원가입" onclick="join();">
	<script>
		function join(){
			var frmElem=document.querySelector('#frm');
			var uid = frmElem.uid.value;
			var upw = frmElem.upw.value;
			var unm = frmElem.unm.value;
			var gender = frmElem.gender.value;

			var param = {//왼쪽이 필드명,오른쪽은 값 (무조건 문자열로 받음)
					uid:uid,
					upw:upw,
					'unm':unm,//'필드명'상관없
					gender:gender
			}
			var param2 = { uid,'1upw1':upw ,unm,gender}
						//멤버필드명과 변수명이름이 같다
			console.log(param);
			console.log(param2);
			
			ajax(param2);
		}
		function ajax(param){
			const init = {
				method:'POST',
				/*
				headers : {
					'Content-Type':'application/json',
				},*/
				body: new URLSearchParams(param)
				//body:JSON.stringify(param),
			}
			fetch('/user/join',init)
			.then(function(res){
				return res.json();
			})
			.then(function(myJson){ //myJson에 응답이 객체로 들어온다!!
				console.log(myJson.result);
				switch(myJson.result){
				case 0:
					alert('회원가입 실패');
					break;
				case 1:
					location.href='/user/login';
					break;
				}
			});
		}
	</script>
</div>