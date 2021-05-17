function delCmt(iboard,icmt){
	console.log(`iboard : ${iboard}, icmt:${icmt}`);
	if(confirm('삭제하시겠습니까?')){
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;		
	}
}