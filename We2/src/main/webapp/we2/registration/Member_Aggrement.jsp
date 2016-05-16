<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/We2_MemberStyle.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/w2_reset.css" type="text/css">
<link rel="stylesheet" href="css/01_1_mypageform.css" type="text/css">

<!-- 회원가입폼을 위해 css적용 -->
<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>

<!-- 약관동의를 위해 사용되는 script -->
<script type="text/javascript">
	function chk() {
		var req = document.form.req.checked;
		var num = 0;

		if (req == true) {
			num = 1;
		}

		if (num == 1) {
			document.form.submit();
		} else {
			alert("개인정보 약관에 동의하셔야 합니다.");
		}
	} //end chk

	function nochk() {
		alert("동의하지 않으면 가입하실 수 없습니다");
		return false;
	} //end nochk//회원가입 함수 선언을 통해 체크를 해야만 이동하는것으로 만듬
</script>

<title>we2회원가입폼</title>

</head>

<body>

	<div id="wrap">
		<!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->

		<!-- chk()과 같이 체크를 하지 않고 넘어가는 것을 방지하기 위해 script로  방지함 -->
		<form action="Member_Aggrement" method="POST" name="form">

			<!-- 주의점 js로 넘어갈때 form안에 있는 name이름을 항상주의!!! -->



			<!-- 1. 상단 로고 부분-->
			<div id="header">

				<div id="headerinner">
					<h2>
						<b> <sub> <a href="Main.jsp">We2</a>
						</sub>
						</b>
					</h2>
				</div>
			</div>
			<!-- header end -->



			<div id="section">

				<h1>
					<span>We2 약관동의</span>
				</h1>
				<br>
				<textarea rows="30" cols="100" readonly="readonly">   
이용약관 

개정 2016.05.20
[제 1장 총칙]
제 1 조 (목적)
이 약관은 전기통신사업법령 및 정보통신망이용촉진등에 관한 법령에 의하여 We2 홈페이지(이하 "당 사이트")에서 제공하는 서비스(이하 "서비스"라 한다)의 이용조건 및 절차에 관한 사항을 규정함을 목적으로 합니다.		
			
제 2 조(약관의 범위 및 개정)
① 이 약관의 내용은 서비스 초기화면에 게시하거나 기타의 방법으로 회원에게 공지함으로써 효력을 발생합니다.
② 당 사이트는 귀학 본 약관 내용에 동의하는 것을 조건으로 귀하에게 서비스를 제공할것이며, 귀하가 본 약관의 
내용에 동의하는 경우, 당 사이트의 서비스 제공 행위 및 귀하의 서비스 사용 행위에는 본 약관이 우선 적용될 것입니다.
③ 이 약관에 동의하는 것은 정기적으로 웹을 방문하여 약관의 변경사항을 확인하는 것에 동의함을 의미합니다.
변경된 약관에 대한 정보를 알지 못해 발생하는 이용자의 피해는 당 사이트에서 책임지지 않습니다.
④ 당 사이트는 "약관의 규제에 관한 법률", "정보통신망이용촉진및정보보호등에관한법률"등 관련법을 위배하지 않는 범위에서 이 약관을 개정할 수 있습니다.
⑤당 사이트가 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행약관과 함께 초기화면에 그 개정약관의 적용일자 7일 전부터 적용일자 전일까지 게시합니다.
⑥회원은 변경된 약관에 동의하지 않을 경우 회원탈퇴(해지)를 요청할 수 있으며, 변경된 약관의 효력 발생일로부터 30일 이후에도 거부의사를 표시하지 아니하고, 서비스를 계속사용할경우 약관의 변경사항에 동의한것으로 간주됩니다.
			
제 3 조 (약관 외 준칙)
이 약관에 명시되지 않은 사항은 전기통신기본법, 전기통신사업법,정보통신망 이용촉진 등에 관한 법률 및 기타 관련법령의 규정에 의합니다.
			
제 4 조 (용어의 정의)	
이용자: 본 약관에 따라 당 사이트가 제공하는 서비스를 받는 자를 말하며 이는 "We2 회원"으로 구분됩니다.
이용계약: 서비스 이용과 관련하여 당 사이트와 이용자간에 체결하는 모든 계약을 말합니다.
아이디(ID) : 회원 식별과 회원의 서비스 이용을 위하여 회원이 선정하고 당 사이트가 부여하는 문자와 숫자의 조합을
말합니다. 
비밀번호 : 회원의 개인정보보호를 위해 회원 자신이 설정한 문자와 숫자의 조합을 말합니다. 
운영자 : 서비스의 전반적인 관리와 원활한 운영을 위하여 당 사이트에서 선정한 사람을 말합니다.
			
제 5 조 (이용계약의 성립)
① 이용계약은 이용자가 본 이용약관 내용에 대한 동의와 이용신청에 대하여 당 사이트의 이용승낙으로 성립합니다. 
② 본 이용약관에 대한 동의는 이용신청 당시 당 사이트의 ‘약관에 동의합니다.’ 항목에 체크함으로써 의사표시를 합니다.  	
   			
제 6 조 (이용신청)
① 이용신청은 온라인으로 회사 소정의 가입신청 양식에서 요구하는 사항을 기록하여 신청합니다. 
② 온라인 가입신청 양식에 기재하는 모든 회원 정보는 실제 데이터인 것으로 간주하며 실명이나 실제 정보를 입력하지 않은 사용자는 법적인 보호를 받을 수 없으며, 서비스 사용의 제한을 받을 수 있습니다. 
   			
 제 7 조 (회원정보 사용에 대한 동의)
① 회원의 개인 정보에 대해서는 당 사이트의 개인정보 보호정책이 적용됩니다. 
② 당 사이트의 회원 정보는 다음과 같이 수집, 사용, 관리, 보호됩니다. 
1. 개인정보의 수집 : 귀하의 당 사이트 서비스 가입시 귀하가 제공하는 정보를 통하여 귀하의 정보를 수집합니다. 
2. 개인정보의 사용 : 당 사이트는 당 사이트 서비스 제공과 관련해서 수집된 귀하의 신성정보를 본인의 승낙 없이 제3자에게 누설, 배포하지 않습니다. 단, 전기통신기본법 등 법률의 규정에 의해 국가기관의 요구가 있는 경우, 범죄에 대한 수사상의 목적이 있거나 방송통신심의위원회의 요청이 있는 경우 또는 기타 관계법령에서 정한 절차에 따른 요청이 있는 경우, 귀하가 당 사이트에 제공한 개인정보를 스스로 공개한 경우에는 그러하지 않습니다. 

3. 개인정보의 관리 : 귀하는 개인정보의 보호 및 관리를 위하여 서비스의 개인정보관리에서 수시로 귀하의 개인 정보를 수정/삭제할 수 있으며, 개인정보 중 불필요하다고 생각되는 부분도 변경/조정할 수 있습니다. 
4. 개인정보의 보호 : 귀하의 개인정보는 오직 귀하만이 열람/수정/삭제 할 수 있으며, 이는 전적으로 귀하의 아이디(ID)와 비밀번호에 의해 관리되고 있습니다. 따라서 타인에게 귀하의 아이디(ID)와 비밀번호를 알려주어서는 아니 되며, 작업 종료 시에는 반드시 로그아웃 하고, 웹 브라우저의 창을 닫아야 합니다. 
(이는 타인과 컴퓨터를 공유하는 인터넷 카페나 도서관 같은 공공장소에서 컴퓨터를 사용하는 경우에 귀하의 정보보호를 위하여 필요한 사항입니다.) 
①  귀하가 당 사이트의 본 약관에 따라 이용신청을 하는 것은 당 사이트가 본 약관에 따라 신청서에 기재된 회원정보를 수집, 이용하는 것에 동의하는 것으로 간주됩니다. 
② 다음 각 호의 어느 하나에 해당하는 이용신청에 대하여는 이를 승낙하지 아니 할 수 있습니다. 

1. 이름이 실명이 아닌 경우 
2. 다른 사람의 명의를 사용하여 신청한 경우 
3. 이용신청 시 필요내용을 허위로 기재하여 신청한 경우 
4. 기타 회사가 정한 이용신청요건이 미비된 경우 

제 9 조 (아이디(ID) 부여 및 변경 등)
① 회원에 대하여 약관에 정하는 바에 따라 아이디(ID)를 부여합니다. 
② 아이디(ID)는 원칙적으로 변경이 불가하며 부득이한 사유로 인하여 변경 하고자 하는 경우에는 해당 아이디(ID)를 해지 하고 재가입해야 합니다. 
③ 다음 각 호에 해당하는 경우에는 회원의 요청 또는 We2 아이디(ID)를 변경 또는 이용을 정지할 수 있습니다. 
 			
[부칙]
(시행일) 이 약관은 2016년 04월 08일부터 시행합니다.
* 본 약관에 동의하지 않으면 회원가입을 하실 수 없습니다.
</textarea>
				<br> <br> <br>


				<h2>
					개인정보 수집 및 이용에 동의합니다&nbsp;&nbsp;<input type="checkbox" name="req">
				</h2>



				<div class="select">
					<td align="center" valign="top">
					<input class="add_btn"
						type="button" value="동의합니다" onclick="return chk()"
						style="width: 150px;" /> <input class="add_btn" type="button"
						value="동의하지 않습니다" onclick="return nochk()" style="width: 150px;" />
					</td>
				</div>
			</div> <!-- section end -->
		</form>
	</div> <!-- wrap end -->
</body>
</html>