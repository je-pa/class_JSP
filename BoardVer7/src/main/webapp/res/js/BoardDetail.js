var cmtFrmElem = document.querySelector('#cmtFrm');
var cmtListElem = document.querySelector('#cmtList');
function regCmt(){
	var cmtVal = cmtFrmElem.cmt.value;
	
	console.log('cmtVal : '+cmtVal);
	console.log(cmtListElem.dataset.iboard);//data-
	
	var param={
		iboard:cmtListElem.dataset.iboard,
		cmt:cmtVal
	};
	regAjax(param);
}
//서버에게 등록해줘
function regAjax(param){
	const init={
		method:'POST',
		body:new URLSearchParams(param)
	};
	
	fetch('/board/cmtInsSel',init) //init안하면 디폴트 형식으로 돌아감
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson)
		
		switch(myJson.result){
		case 0:
			alert('등록실패');
			break;
		case 1:
			alert('등록완료');
			getListAjax();
			break;	
		}
	});
}
//서버에게 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax(){
	var iboard = cmtListElem.dataset.iboard;
	
	fetch('cmtInsSel?iboard='+iboard)
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
		
		makeCmtElemList(myJson);
	});
}
function makeCmtElemList(data){
	cmtListElem.innerHTML='';//댓글 쓸때마다 테이블이 또 생기는것을 방지
	
	var tableElem = document.createElement('table');
	var trElemTitle = document.createElement('tr');
	var thElemCtnt = document.createElement('th');
	var thElemWriter = document.createElement('th');
	var thElemRegdate = document.createElement('th');
	var thElemBigo = document.createElement('th');
	
	thElemCtnt.innerText='내용';
	thElemWriter.innerText='작성자';
	thElemRegdate.innerText='작성일';
	thElemBigo.innerText='비고';
	/*
		<table></table>
		<tr></tr>
		<th>내용</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>비고</th>
	 */
	
	trElemTitle.append(thElemCtnt);//tr에 소속시켜줌
	trElemTitle.append(thElemWriter);
	trElemTitle.append(thElemRegdate);
	trElemTitle.append(thElemBigo);
	
	tableElem.append(trElemTitle);
	
	cmtListElem.append(tableElem);
	/*
		<div id="cmtList">
			<table>
				<tr>
					<th>내용</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>비고</th>
				</tr>
			</table>
		</div>
	 */
	var loginUserPk = cmtListElem.dataset.login_user_pk;
	
	data.forEach(function(item){
		var trElemItem = document.createElement('tr');
		var tdElemCtnt = document.createElement('td');
		var tdElemWriter = document.createElement('td');
		var tdElemRegdate = document.createElement('td');
		var tdElemBigo = document.createElement('td');
		
		tdElemCtnt.append(item.cmt);
		tdElemWriter.append(item.writerNm);
		tdElemRegdate.append(item.regdate);
		//비고 - 버튼 일단 비움
		
		if(parseInt(loginUserPk)===item.iuser){
			var delBtn = document.createElement('button');
			var modBtn = document.createElement('button');
			
			//삭제버튼 클릭
			delBtn.addEventListener
			('click'/*이벤트가 무엇인지 hover*/ ,function(){
				delAjax(item.icmt);
			})
			
			delBtn.innerText = '삭제';
			modBtn.innerText='수정';
			
			tdElemBigo.append(delBtn);
			tdElemBigo.append(modBtn);
		}
		
		trElemItem.append(tdElemCtnt);
		trElemItem.append(tdElemWriter);
		trElemItem.append(tdElemRegdate);
		trElemItem.append(tdElemBigo);
		
		tableElem.append(trElemItem);
	});
}
function delAjax(icmt){
	fetch('cmtDelUpd?icmt='+icmt)//호출 프로미스 객체를 리턴?
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
		
		switch(myJson.result){
		case 0:
			alert('댓글 삭제를 실패');
			break;
		case 1:
			getListAjax();
			break;
		}
	});
}
getListAjax();//이 파일 임포트되면 함수 호출됨