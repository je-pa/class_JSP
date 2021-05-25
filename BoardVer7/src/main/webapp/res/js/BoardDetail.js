var cmtFrmElem = document.querySelector('#cmtFrm');
function regCmt(){
	var cmtVal = cmtFrmElem.cmt.value;
	
	console.log('cmtVal : '+cmtVal);
	console.log(cmtFrmElem.dataset.iboard);
	
	var param={
		iboard:cmtFrmElem.dataset.iboard,
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
			break;	
		}
	});
}
//서버에게 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax(){
	var iboard = cmtFrmElem.dataset.iboard;
	
	fetch('cmtInsSel?iboard='+iboard)
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
	});
}
getListAjax();