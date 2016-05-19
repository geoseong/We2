/**
 * 
 */

function charcheck(){
	if(document.frm.itemContent.value.length>=3000){
		alert('최대 입력가능 자릿수 1000자를 넘었습니다.\n 현재 문자열 길이 : ' + frm.itemContent.value.length);
		return false;
	}
	if(document.frm.itemTitle.value.length==0){
		alert('글제목은 반드시 입력되어야 합니다.');
		return false;
	} 
	if(document.frm.itemContent.value.length==0){
		alert('내용은 적어도 한글자 이상은 입력해주세요~');
		return false;
	}
	alert('현재 문자열 길이 : ' + frm.itemContent.value.length);
	return true;
}
