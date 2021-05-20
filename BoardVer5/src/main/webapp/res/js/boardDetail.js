var insFrmElem = document.querySelector('#insFrm');
var updFrmElem = document.querySelector('#updFrm');

//댓글삭제
function delCmt(iboard,icmt){
	console.log(`iboard : ${iboard}, icmt:${icmt}`);
	if(confirm('삭제하시겠습니까?')){
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;		
	}
}
//댓글수정
function updCmt(icmt, cmt){
	console.log('icmt : %d',icmt);
	console.log('cmt : %s',cmt);
	updFrmElem.icmt.value=icmt;
	updFrmElem.cmt.value=cmt;
	
	insFrmElem.className = 'hidden';
	updFrmElem.className = '';
}

function showInsFrm(){
	insFrmElem.className='';
	updFrmElem.className='hidden';
}