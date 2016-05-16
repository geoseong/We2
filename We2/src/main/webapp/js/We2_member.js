function loginCheck() {
	if (document.frm.userid.value == "") {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	document.frm.submit();	
	return true;
}

function idCheck() {
	if (document.frm.userId.value == "") {
		alert('아이디를 입력하여 주십시오.');
		frm.userId.focus();
		return;
	}
	var url = "We2_idCheck?userId=" + document.frm.userId.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}
/*function pwCheck() {
	if (document.frm.pwd.value == "") {
		alert('비밀번호를 입력하여 주십시오.');
		frm.pwd.focus();
		return false;
	}
	var url = "alert/notmatch.jsp";
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}*/
function checkLength_1(objname, maxlength){
	var objstr = objname.value; //입력된 문자열을 담을 변수
	var objstrlen = objstr.length; // 전체길이//변수 초기화
	var maxlen = maxlength; //제한할 글자수 최대크기
	
	var i = 0;	// for문에 사용
	var bytesize = 0; //	바이트크기
	var strlean = 0; //입력된 문자열의 크기
	var onechar =  ""; //char단위로 추출시 필요한 변수
	var objstr2 = ""; //허용된 글자수까지만 포함한 최종문자열
	//입력된 문자열의 총바이트수 구하기
	for(i = 0; i<objstrlen; i++){
		//한글자추출
		onechar =objstr.charAt(i);
		if(escape(onechar).length > 4){
			bytesize += 2; //한글이면 2를 더한다.
		}else{
	bytesize++; // 그 밖의 경우는 1을 더한다.
		}
		if(bytesize <=maxlen){//전체 크기가 maxlen를 넘지 않으면 
		strlen=i+1;	//1씩 증가
		}
		}
		//총바이트수가 허용된 문자열의 최대값을 초과하면
		if(bytesize >maxlen){
			alert(((objname.name.match("id"))?"이름":"이름")+
					"에서 허용된 문자열의 최대값("+maxlen+")을 초과했습니다. /초과된 내용은 자동으로 삭제 됩니다.");
			//match를 이용해서 영어로 된 name을 한글로 변환해서 출력한다.
			objstr2 = objstr.substr(0,strlen);
			objname.value = objstr2;
		}
			objname.focus();
		}

function checkLength(objname, maxlength){
	var objstr = objname.value; //입력된 문자열을 담을 변수
	var objstrlen = objstr.length; // 전체길이//변수 초기화
	var maxlen = maxlength; //제한할 글자수 최대크기
	
	var i = 0;	// for문에 사용
	var bytesize = 0; //	바이트크기
	var strlean = 0; //입력된 문자열의 크기
	var onechar =  ""; //char단위로 추출시 필요한 변수
	var objstr2 = ""; //허용된 글자수까지만 포함한 최종문자열
	//입력된 문자열의 총바이트수 구하기
	for(i = 0; i<objstrlen; i++){
		//한글자추출
		onechar =objstr.charAt(i);
		if(escape(onechar).length > 4){
			bytesize += 2; //한글이면 2를 더한다.
		}else{
	bytesize++; // 그 밖의 경우는 1을 더한다.
		}
		if(bytesize <=maxlen){//전체 크기가 maxlen를 넘지 않으면 
		strlen=i+1;	//1씩 증가
		}
		}
		//총바이트수가 허용된 문자열의 최대값을 초과하면
		if(bytesize >maxlen){
			alert(((objname.name.match("id"))?"아이디":"패스워드")+
					"에서 허용된 문자열의 최대값("+maxlen+")을 초과했습니다. /초과된 내용은 자동으로 삭제 됩니다.");
			//match를 이용해서 영어로 된 name을 한글로 변환해서 출력한다.
			objstr2 = objstr.substr(0,strlen);
			objname.value = objstr2;
		}
			objname.focus();
}

function idOk(userId){
	opener.frm.userId.value = userId;
	//opener.frm.reid.value = userId;
	self.close();
}

function joinCheck() {

	if(document.frm.name.value.length ==0) {
		alert("이름을 써주세요");
		frm.name.focus();
		return false;
	}

	if (document.frm.userid.value.length == 0){
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}

	if(document.frm.userid.value.length < 4){
		alert("아이디를 4글자이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}

	if(document.frm.pwd.value == ""){
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}

	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
	return false;
	}

	if(document.frm.reid.value.length ==0){
		alert("중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	return true;
}