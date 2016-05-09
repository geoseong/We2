<!doctype html>
<html>
<head>
<title>네이버 카페 채팅</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico?1" />
<meta name="robots" content="noindex, nofollow" />

<style type="text/css">
.atcmp_on {
	background-color : #F0F2F9;
}
.fog { position:absolute; left:0; top:0; padding:0; margin:0; border:0;	width:100px; height:100px; background-color:#000; opacity:0.12; z-index:1 }
</style>
<link rel="stylesheet" href="/static/css/chat_broker/cafe_chat-1450085567000-68675.css" type="text/css">




<script>
var g_sUserId = "imf4";
var g_sCafeId = "28357909";
var g_sChatBrokerUrl = 'http://chat.cafe.naver.com';
var g_sChatBrokerSSLUrl = 'https://chat.cafe.naver.com';
var g_sChatBrokerCommonUrl = '//' + 'chat.cafe.naver.com';
var g_sCafeMainUrl = 'http://cafe.naver.com';
var g_sCafeMainSSLUrl = 'https://secure.cafe.naver.com';
var g_sChatImgs = 'http://cafechat.phinf.naver.net';
var g_sChatImgsSSL = 'https://ssl.pstatic.net/cafechat.phinf';
var g_sUploadUrl = 'https://up.cafe.naver.com';
var g_sStickerImageUrl = 'https://ssl.phinf.net/gfmarket';

var g_sSessionServerUrl = 'https://ss.cafe.naver.com';
var g_htSessionServerUrl = {
		'1' : 'https://ss1.cafe.naver.com',
		'2' : 'https://ss2.cafe.naver.com',
		'3' : 'https://ss3.cafe.naver.com',
		'4' : 'https://ss4.cafe.naver.com',
		'5' : 'https://ss5.cafe.naver.com',
		'6' : 'https://ss6.cafe.naver.com',
		'7' : 'https://ss7.cafe.naver.com',
		'8' : 'https://ss8.cafe.naver.com',
		'9' : 'https://ss9.cafe.naver.com',
		'10' : 'https://ss10.cafe.naver.com',
		'11' : 'https://ss11.cafe.naver.com',
		'12' : 'https://ss12.cafe.naver.com',
		'13' : 'https://ss13.cafe.naver.com',
		'14' : 'https://ss14.cafe.naver.com',
		'15' : 'https://ss15.cafe.naver.com',
		'16' : 'https://ss16.cafe.naver.com',
		'17' : 'https://ss17.cafe.naver.com',
		'18' : 'https://ss18.cafe.naver.com',
		'19' : 'https://ss19.cafe.naver.com',
		'20' : 'https://ss20.cafe.naver.com'
	};
var g_nSessionServerPort = '443';

var g_deviceType = 2001;
</script>


<meta name="decorator" content="Default" />
<meta name="jsfooter" content="/jsp/home/include/ScriptChatHome.jsp" />

<script type="text/javascript">
window.name='CafeChatHome';
document.domain = "naver.com";
</script>

<script>
	document.domain='naver.com';
	try{
		document.execCommand("BackgroundImageCache", false, true);
	}catch (err){
	}
</script>
</head>
<body  >


<div id="chat_wrap" class="main">
	<h1 class="blind">네이버 카페 채팅</h1>
	<div class="chat_header">
		
		<ul id="tabMenuContainer" class="lnb_tab">
		<li class="tab"><a href="#" class="N=a:top.chat _click(ChatHomeGNB|ShowMyChatTab) _stopDefault"><strong class="blind">내채팅</strong></a></li>
		<li class="tab2"><a href="#" class="N=a:top.openchat _click(ChatHomeGNB|ShowOpenRoomTab) _stopDefault"><strong class="blind">공개채팅</strong></a></li>
		<li class="tab3"><a href="#" class="N=a:top.member _click(ChatHomeGNB|ShowMemberTab) _stopDefault"><strong class="blind">멤버</strong></a></li>
		</ul>
		<div class="fr">
			<a href="#" id="configBtn" class="N=a:top.set _click(ChatHomeGNB|ShowConfig) _stopDefault">환경 설정</a>
			<button type="button" id="ChatRoomCreateGnbBtn" class="N=a:och.open make_chat_room _click(OpenRoomList|ShowRoomNameLayer) _stopDefault" style="display:none;"><strong class="blind">채팅방 만들기</strong></button>
		</div>
	</div>
	<hr>
	
<div id="mychat_tab_container">
	
	<div id="mychat_container" style="display:none;">
		<div class="chat_content">
			<h2 class="blind">참여중인 채팅방</h2>
			<div class="chatroom_lst_section">
				<div class="lst_tit">
					<strong class="tit">채팅방 <em id="myChatRoomCnt">0</em>개</strong>
					<a href="#" class="btn_edit_chatroom _click(ChatRoomList|ShowDeleteRoomBtn) _stopDefault"><i></i><strong>편집</strong></a>
				</div>
				<div class="lst_area">
					<ul id="myChatRoomListPane">
						
					</ul>
				</div>
			</div>
		</div>
		<div class="chat_footer" style="display:none">
			<div class="btns_v2">
				<button type="button" class="btn cfm _click(ChatRoomList|HideDeleteRoomBtn) _stopDefault"><strong>완료</strong></button>
			</div>
		</div>
		<hr>
	</div>
	
	
	<div id="mychat_container_not_exist_room" style="display:none;">
		<div class="chat_content noti">
			<div class="noti_section">
				<div class="noti_area">
					<div class="cont">
						
						<div class="bg"><span class="bg_chat"></span></div>
						<h2 class="tit">채팅 중인 방이 없습니다.</h2>
						<p class="dsc">공개채팅탭이나 멤버탭에서<br>채팅방을 만들어보세요.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	
	
<div id="openroom_tab_container" style="display:none">
	
	<div id="openroom_container">
		
		<div id="openRoomContent" class="chat_content2">
			<h2 class="blind">공개채팅</h2>
			<div class="chatroom_lst_section">
				<div class="lst_tit">
					<h3 class="blind">가입 카페 목록</h3>
					
					<div id="myCafeListInOpenRoomListTab"></div>
				</div>
				<div id="openRoomListContainer" class="lst_area">
					<div class="opts">
						
						<label class="on" for="orderByLastMsgTimestamp"><input type="radio" id="orderByLastMsgTimestamp" name="orderBy" value="LastMsgTimestamp" checked="checked" class="_click(OpenRoomList|OrderBy)"> <span>최신순</span></label>
						<label for="orderByRoomName"><input type="radio" id="orderByRoomName" name="orderBy" value="RoomName" class="_click(OpenRoomList|OrderBy)"> <span>가나다순</span></label>
					</div>
					<ul id="openRoomListPane">
					</ul>
					<div id="pagingArea" class="paginate"> 
						<a href="#" class="pre">이전</a> 
						<a href="#" class="next">다음</a> 
					</div>
					<div id="notiLastMsgTimestampPane" class="btm_dsc">
						<div class="info_inr">
							<p class="dsc">대화 업데이트 순으로 대화방이 50개까지 노출됩니다. <br>전체 방목록은 가나다순으로 볼 수 있습니다.</p>
							<a href="#" class="more _click(OpenRoomList|ShowOpenRoomListOrderByRoomName)">전체 방목록보기</a>
						</div>
					</div>
				</div>
				
				<div id="openRoomListNotExistContainer" class="noti_section" style="display:none">
					<div class="noti_area">
						<div class="cont">
							
							<div class="bg"><span class="bg_chat"></span></div>
							<h2 class="tit">개설된 공개채팅방이 없습니다.</h2>
							<p class="dsc">공개방 만들기로 공개채팅을 시작해보세요.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="chat_footer" style="display:none">
			<div class="btns_v2">
				<button type="button" class="btn cfm N=a:grp.mngok _click(OpenRoomList|HideCloseBtn)"><strong>완료</strong></button>
			</div>
		</div>
	</div>
	
	<div id="openRoomEditComplete" class="chat_footer" style="display:none">
		<div class="btns_v2">
			<button type="button" class="btn cfm"><strong>완료</strong></button>
		</div>
	</div>
</div>

	
	
<div id="cafemember_tab_container">
	
	<div id="cafemember_container" style="display:none">
		<div class="chat_content noti">
			<h2 class="blind">가입 카페 멤버 보기/찾기/초대</h2>
			
			<div id="rolling_vt" class="rolling_vt">
				<ul class="rolling_lst">
				<li class="rolling_itm">
					<div class="member_section">
						<div class="join_cafe_lst">
							<h3 class="blind">가입 카페 목록</h3>
							<div id="myCafeList"></div>
						</div>
					
						
						<div id="not_allow_chat_info_block" class="noti_section" style="display:none;">
							
							<div class="noti_area" id="unused_chat_cafe_info" style="display:none;">
								<div class="cont">
									<h2 class="tit">해당 카페에서는 <br>채팅을 사용할 수 없습니다.</h2>
									<p class="dsc">선택하신 카페는 운영진이 <em>그룹채팅 사용안함</em> 으로 설정하였습니다.</p>
									<div class="bnr">
										<div class="ad_cafeapp">
											<p>카페 앱에서 1:1 대화를 사용할 수 있습니다.</p>
											<a href="#" class="_click(Utility|SendAppInstallSms) _stopDefault"><em class="blind">카페 앱 설치 문자 보내기</em></a>
										</div>
									</div>
								</div>
							</div>
							
							<div class="noti_area" id="not_allowed_member_level_info" style="display:none;">
								<div class="cont">
									<h2 class="tit">해당 카페에서는 <br>채팅을 사용할 수 없습니다.</h2>
									<p class="dsc">선택하신 카페의 채팅 등급이 <em id="chat_join_member_level">성실멤버</em> 이상으로 설정되어있습니다.</p>
									<div class="bnr">
										<div class="ad_cafeapp">
											<p>카페 앱에서 1:1 대화를 사용할 수 있습니다.</p>
											<a href="#" class="_click(Utility|SendAppInstallSms) _stopDefault"><em class="blind">카페 앱 설치 문자 보내기</em></a>
										</div>
									</div>
								</div>
							</div>
						</div>

						
						<div id="invite_member_block">
							
							<div class="member_srch_frm">
								<h3 class="blind">멤버 검색</h3>
								<p id="searchKeyword" class="input_srch_keyword">
									<i class="ico_search"></i>
									<span><input id="query" type="text" class="_click(CafeMemberSearch|RemoveDefaultKeyword)" value="채팅방에 초대할 멤버를 검색해 보세요."></span>
									<button type="button" class="btn_del _click(CafeMemberSearch|InitKeyword) _stopDefault">검색어 삭제</button>
								</p>
							</div>
							
							<div id="cafeMemberSearchBlock" class="member_lst_info" style="display:none">
								<h3 class="blind">검색결과</h3>
								<div id="cafeMemberSearch" class="lst_area">
									<ul id="searchResultList" class="mem_lst">
									</ul>
								</div>
							</div>
							
							<div id="cafeMemberListBlock" class="member_lst_info">
							</div>
						</div>
					</div>
				</li>
				<li id="invite_member_list" class="rolling_itm">
					<div id="inviteInfoLayer" class="ly_chat_type3 ly_mem_invite" style="opacity:0;display:none;">
						<div class="ly_cont">
							<p class="txt">추가하였습니다</p>
							<i class="bgl"></i><i class="bgr"></i><i class="tail"></i>
						</div>
					</div>
					<div class="member_section2">
						<div class="member_tit_area">
							<a href="#" class="act_opn _click(InviteRoomMember|ToggleInviteMemberList) _stopDefault">
								<h3 class="tit">초대한 멤버</h3>
								<p class="info">
									<strong id="inviteMemberCnt">0</strong>명
									
									<span class="blind">열기</span><em class="off"></em>
								</p>
							</a>
						</div>
						
						<div class="member_lst_info">
							<div class="lst_area">
								<ul id="inviteMemberList" class="mem_lst">
								</ul>
							</div>
						</div>
					</div>
				</li>
				</ul>
			</div>
			
		</div>

		<div id="chat_room_create_btn" class="chat_footer">
			<div class="btns_v2">
				<button type="button" class="btn cfm N=a:mem.creatroom _click(CafeMemberTab|ShowRoomNameLayer) _stopDefault">채팅방 만들기</button>
			</div>
		</div>
	</div>
	
	
	<div id="cafemember_container_not_exist_cafe" style="display:none">
		<div class="chat_content noti">
			<div class="noti_section">
			<div class="noti_area">
				<div class="cont">
					
					<div class="bg"><span class="bg_cafe"></span></div>
					<h2 class="tit">가입한 카페가 없습니다.</h2>
					<p class="dsc">네이버에서 카페에 가입하시면 <br>카페 채팅을 사용하실 수 있습니다.</p>
				</div>
			</div>
			</div>
		</div>
	</div>
</div>
	

	
<div id="config_home_container" style="display:none">
	<div class="chat_content">
			<h2 class="blind">환경설정</h2>
			
			<div id="ConfigMenu" class="chat_config_section" style="display:block">
				<div class="lst_tit">
					<strong class="tit">채팅방</strong>
				</div>
				<div class="lst_area">
					<ul class="config_menu">
					<li><a href="#" class="_click(ConfigHome|ShowGroupChatBlockConfig) _stopDefault">그룹 채팅 사용 설정</a></li>
					<li><a href="#" class="_click(ConfigHome|ShowOneToOneBlockConfig) _stopDefault">1:1 대화 차단 설정</a></li>
					</ul>
				</div>
			</div>
			
	

<div id="groupChatBlockConfigBody" class="chat_config_section" style="display:none">
	<div class="lst_tit">
		<strong class="tit">그룹채팅 사용 설정</strong>
	</div>
	<div class="lst_area">
		<div class="bnr_noti">
			<div class="bnr_bg bg_group_chat_config">
				<strong class="blind">그룹채팅 사용여부 설정하기</strong>
			</div>
			<p class="dsc">그룹채팅을 원치 않는 카페는 사용안함으로 설정할 수 있습니다.<br>이미 참여중인 그룹 채팅방에는 적용 되지 않습니다.</p>
		</div>
		<ul id="groupChatUseConfigList" class="join_cafe_lst2">
		</ul>
	</div>
</div>

	
	

<div id="oneToOneBlockConfigBody" class="chat_config_section" style="display:none">
	<div class="lst_tit">
		<strong class="tit">1:1 대화 차단 설정</strong>
	</div>
	<div id="blockMemberListBox" class="lst_area config_lst_info">
		<ul id="oneToOneBlockMemberList" class="mem_lst mem_lst2">
		</ul>
	</div>
	
	<div id="notExistBlockMemberInfo" class="noti_section" style="display:none">
		<div class="noti_area">
			<div class="cont">
				
				<div class="bg"><span class="bg_people"></span></div>
				<h2 class="tit">1:1 대화를 차단한 멤버가 없습니다.</h2>
				<p class="dsc">1:1 대화창 메뉴에서 멤버를 차단하실 수 있습니다.</p>
			</div>
		</div>
	</div>
</div>


	</div>
</div>
</div>


<script id="chattingTabTpl" type="text/template">
{for roomInfo in roomList}
<li id="room_{=roomInfo.cafeId}_{=roomInfo.roomId}">
	<div class="info">
		<span class="thmb">{if roomInfo.cafeImageUrl}<img src="{=roomInfo.cafeImageUrl}" width="36" height="36" alt="">{/if}<i></i></span>
			<div class="caferoom_info">
				<h3 class="subject">{js oUtil.escapeHTML(=roomInfo.roomName)}</h3>
				<div class="dsc">
					{if roomInfo.openType == 'O'}
					<span class="blind">공개채팅방</span>
					{/if}
					{if roomInfo.roomType != 0}
					<strong class="num"><em class="ico{if roomInfo.openType == 'O'} ico2{/if}">참여인원 </em>{=roomInfo.onlineMemberCnt}</strong>
					{/if}
					{if roomInfo.unreadCnt > 0}
					<span class="ico_new">새로운 대화내용 있음</span>
					{/if}
				</div>
			</div>
		<p class="cafename"><em class="blind">카페명 </em>{js oUtil.escapeLtGt(=roomInfo.cafeName)}</p>
	</div>
	<div class="info2">
	{if roomInfo.lastMsg}
		<div class="last_mgs">
			<div class="inr">
				<p class="txt">
					<span>{js oUtil.escapeHTML(=roomInfo.lastMsg)}</span>
					{if roomInfo.lastMsgTimestampLabel}
					<em>{=roomInfo.lastMsgTimestampLabel}</em>
					{/if}
				</p>
				<i class="bgl"></i><i class="bgr"></i><i class="bgt"></i>
			</div>
		</div>
	{/if}
		<span class="btn_out_chatroom" style="display:none"><button type="button" class="_click(ChatRoomDelete|DeleteRoom|{=roomInfo.cafeId}|{=roomInfo.roomId}) _stopDefault">나가기</button></span>
	</div>
	
	<button type="button" class="btn_enter_chatroom _click(ChatRoomList|OpenChatRoom|{=roomInfo.cafeId}|{=roomInfo.roomId}) _stopDefault"><span class="blind">채팅창 열기</span></button>
</li>
{/for}
</script>

<script id="openRoomListTpl" type="text/template">
{for roomInfo in roomList}
<li id="room_{=roomInfo.cafeId}_{=roomInfo.roomId}">
	<div class="info">
		
		<span class="thmb">{if roomInfo.cafeImageUrl}<img src="{=roomInfo.cafeImageUrl}" width="36" height="36" alt="">{/if}<i></i></span>
		<div class="caferoom_info">
			<h3 class="subject">{js oUtil.escapeHTML(=roomInfo.roomName)}</h3>
			<div class="dsc">
				<strong class="num"><em class="ico ico2">참여인원 </em>{=roomInfo.memberCount}</strong>
				
			</div>
		</div>
		<p class="cafename"><em class="blind">카페명 </em>{js oUtil.escapeLtGt(=roomInfo.cafeName)}</p>
	</div>
	{if roomInfo.lastMsgTimestampLabel}
	<div class="info2">
		
		<div class="last_mgs">
			<div class="inr">
				<p class="txt">
					<em>{=roomInfo.lastMsgTimestampLabel}</em>
					<span>새로운 대화가 올라왔습니다.</span>
				</p>
				<i class="bgl"></i><i class="bgr"></i><i class="bgt"></i>
			</div>
		</div>
	</div>
	{/if}
	
	<div class="info3">
		<span class="btn_out_chatroom"><button type="button" class="N=a:grp.mngclose _click(OpenRoomManager|ShowOpenRoomCloseConfirmLayer|{=roomInfo.cafeId}|{=roomInfo.roomId})">종료</button></span>
	</div>
	
	{if roomInfo.participant}
	<div class="ico_chatting" style="display:block">
		<span class="blind">참여중인 채팅방</span>
	</div>
	{/if}
	<button type="button" class="btn_enter_chatroom N=a:och.room _click(ChatRoomList|OpenChatRoom|{=roomInfo.cafeId}|{=roomInfo.roomId}) _stopDefault"><span class="blind">채팅창 열기</span></button>
</li>
{/for}
</script>



<div id="openRoomNameInsertionLayer" class="ly_chat_type ly_type_v4" style="display:none;top:400px;left:560px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>공개 채팅방 이름을 만들어주세요.</strong></p>
		<div class="dsc2">
			<em class="chk_byte"><span id="openRoomByteLabel">0</span>/40 byte</em>
			
			<input id="openRoomNameInputField" class="__notnull __byte(1~40) __notspace _click(OpenRoomList|RemoveDefaultRoomName) _keydown(OpenRoomList|CreateRoom)" type="text" cols="20" value="" maxlength="80">
			<div id="openRoomNameLayerDesc" class="noti" style="display:none;">방 이름을 입력해주세요.</div>
		</div>
	</div>
	<div id="openRoomNameCaptcha" class="ly_capt" style="display:block;">
		<p class="tit"><strong>보안확인이 필요합니다.</strong></p>
		<p class="dsc">프로그램을 이용한 자동 이용을 방지하기<br>위해 보안 절차를 거치고 있습니다.<br>아래 이미지를 보이는 대로 입력해주세요.</p>
		<div class="capt_img">
			<img id="openRoomCaptchaImg" src="" width="200" height="90" alt="">
		</div>
		<div class="capt_input">
			<label for="" class="blind">캡챠</label>
			<input id="openRoomNameCaptchaKey" type="hidden" value="" />
			<input id="openRoomNameCaptchaValue" class="__notnull __notspace _keydown(OpenRoomList|CreateRoom)" type="text" cols="20" value="">
			<span class="btn"><button type="button" class="_click(OpenRoomList|ChangeCaptcha) _stopDefault">새로고침</button></span>
			<p id="openRoomNameCaptchaDesc" class="noti txt_f" style="display:none;">보안문자를 잘못 입력하셨습니다.</p>
		</div>
    </div>
	<div class="ly_btns">
		<button type="button" class="btn cfm N=a:och.titok _click(OpenRoomList|CreateRoom) _stopDefault">확인</button>
		<button type="button" class="btn cncl N=a:och.titcancel _click(LayerManager|HideLayer|openRoomNameInsertionLayer) _stopDefault">취소</button>
	</div>
</div>


<div id="openRoomPromotionLayer" style="display:none;position:absolute;top:50%;left:50%;z-index:999;width:364px;height:253px;margin:-125px 0 0 -180px;background:url(/image/ly_openchat_open.png)">
	<div class="blind">
        <h2>카페 공개채팅 OPEN!</h2>
        <p>PC, 모바일 카페앱 사용자 상관없이 카페 멤버면 누구나 참여할 수 있는 공개 채팅방을 지금 만들어보세요.</p>
        <ol>
        <li>원하는 카페를 선택하세요.</li>
        <li>공개방을 만들어보세요.</li>
        </ol>
	</div>
	<button type="button" class="clse _click(LayerManager|HideLayer|openRoomPromotionLayer) _stopDefault" style="display:inline-block;position:absolute;top:1px;right:4px;width:34px;height:34px"><span class="blind">레이어 닫기</span></button>
</div>


<div id="openRoomCloseConfirmLayer" class="ly_chat_type ly_type_v9" style="display:none;top:0;left:0;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>선택하신 채팅방을 종료하시겠습니까?</strong></p>
		<p class="dsc">채팅방이 목록에서 사라지고,<br>채팅방 내 모든 대화가 중단됩니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="N=a:grp.mngcok btn cfm _click(LayerManager|ClickLayer|openRoomCloseConfirmLayer|Confirm) _stopDefault">채팅방 종료</button>
		<button type="button" class="N=a:grp.mngccancel btn cncl _click(LayerManager|HideLayer|openRoomCloseConfirmLayer) _stopDefault">취소</button>
	</div>
</div>

<script id="cafeMemberListTpl" type="text/template">
	<h3 class="blind">최근 방문한 멤버</h3>
	<div class="lst_area">
		<ul id="cafeMemberList" class="mem_lst">
		{if resBody.myInfo.memberId}
		<li class="my">
			<div class="pers_nick">
				<div class="inr">
					<span class="thmb">{if resBody.myInfo.memberProfileImageUrl}<img src="{=resBody.myInfo.memberProfileImageUrl}" width="30" height="30" alt="">{/if}<i></i></span>
					<em class="txt">{=resBody.myInfo.nickname}</em>
					<button type="button" class="btn_set _click(CafeMemberList|EditMyInfo) _stopDefault">별명 및 내 정보 설정</button>
				</div>
			</div>
		</li>
		{/if}
		{for member in resBody.memberList}
		<li id="list_{=member.memberId}">
			<div class="pers_nick">
				<div class="inr">
					<span class="thmb">{if member.memberProfileImageUrl}<img src="{=member.memberProfileImageUrl}" width="30" height="30" alt="">{/if}<i></i></span>
					<em class="txt">{=member.nickname}</em>
					<button type="button" class="btn_act add _click(InviteRoomMember|ToggleInviteMember|{=member.memberId}|{=member.nickname}|{=member.memberProfileImageUrl}) _stopDefault">바로추가</button>
				</div>
			</div>
		</li>
		{/for}
		</ul>
	</div>
	<div class="info_area">
		<div class="info_inr" id="cafeMemberListDesc">
			<p class="dsc">
				<span class="cafe_name">
					<span class="inr">
						<span class="txt">{js oUtil.escapeLtGt(=cafeName)}</span>
						<span class="txt2">카페의</span>
					</span>
				</span>
				<em>{=resBody.totalMemberCnt}</em>명의 멤버와 채팅할 수 있습니다.<br>
				<strong>검색기능</strong>으로 더 많은 멤버들을 만나보세요.
			</p>
		</div>
	</div>
</script>

<script id="cafeMemberSearchTpl" type="text/template">
{if myInfo}
	<li class="my">
		<div class="pers_nick">
			<div class="inr">
				<span class="thmb">{if profileImage}<img src="{=profileImage}" width="30" height="30" alt="">{/if}<i></i></span>
				<em class="txt">{=nickname}</em>
				<button type="button" class="btn_set _click(CafeMemberList|EditMyInfo) _stopDefault">별명 및 내 정보 설정</button>
			</div>
		</div>
	</li>
{else}
	<li id="search_{=id}">
		<div class="pers_nick">
			<div class="inr">
				<span class="thmb">{if profileImage}<img src="{=profileImage}" width="30" height="30" alt="">{/if}<i></i></span>
				<em class="txt">{=txt}</em>
				<button type="button" class="btn_act {if alreadyJoin}chat{elseif alreadyInvite}chk{else}add{/if} _click(InviteRoomMember|ToggleInviteMember|{=id}|{=nickname}|{=profileImage}) _stopDefault">바로추가</button>
			</div>
		</div>
	</li>
{/if}
</script>

<script id="myCafeListTpl" type="text/template">
	<select name="cafeId" id="cafeId" class="selectbox-source">
	{for cafe in cafeList}
		<option class="N=a:och.cafe _openRoomCount({=cafe.openRoomCount}) _hasClosePermission({=cafe.closePermission})" value="{=cafe.cafeId}">{js oUtil.escapeLtGt(=cafe.cafeName)}</option>
	{/for}
	</select>
	<div class="selectbox-box">
		<div class="sel_cont selectbox-label"></div>
	</div>
	<div id="openRoomEditBtn" class="btn_area" style="display:none">
		<a href="#" class="N=a:grp.mngman btn_edit_chatroom _click(OpenRoomList|ShowCloseBtn) _stopDefault"><i></i><strong>관리</strong></a>
	</div>
	<div class="selectbox-layer">
		<div class="selectbox-list"></div>
	</div>
</script>

<script id="myCafeListItemTpl" type="text/template">
	<div class="sel_inr _item_{=cafe.cafeId}">
		<span class="thmb">{if cafe.cafeThumbnail}<img src="{=cafe.cafeThumbnail}" width="30" height="30" alt="">{/if}<i></i></span>
		<div class="sel_label">
			<span class="tit">{js oUtil.escapeLtGt(=cafe.cafeName)}</span>
		</div>
		<span class="sel_bu"></span>
	</div>
</script>

<script id="myCafeListOpenRoomItemTpl" type="text/template">
	<div class="sel_inr _item_{=cafe.cafeId}">
		<span class="thmb">{if cafe.cafeThumbnail}<img src="{=cafe.cafeThumbnail}" width="30" height="30" alt="">{/if}<i></i></span>
		<div class="sel_label">
			<span class="tit">{js oUtil.escapeLtGt(=cafe.cafeName)}</span>
			{if (cafe.openRoomCount > 0)}
			<em style="display:inline">
				<span class="blind">(공개채팅방 수 :</span><em class="num">{if cafe.openRoomCount > 0}{=cafe.openRoomCount}{else}0{/if}</em><span class="blind"> )</span>
			</em>
			{/if}
		</div>
		<span class="sel_bu"></span>
	</div>
</script>

<script id="inviteMemberTpl" type="text/template">
	<li id="invite_{=memberId}" class="_memberId({=memberId})">
		<div class="pers_nick">
			<div class="inr">
				<span class="thmb">{if profileImage}<img src="{=profileImage}" width="30" height="30" alt="">{/if}<i></i></span>
				<em class="txt">{=nickname}</em>
				<button type="button" class="btn_act del _click(InviteRoomMember|ToggleInviteMember|{=memberId}) _stopDefault">초대취소</button>
			</div>
		</div>
	</li>
</script>


<div id="notExistInviteMemberLayer" class="ly_chat_type ly_type_v3 ly_type_v7" style="display:none;top:200px;left:500px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>멤버를 선택해주세요.</strong></p>
		<p class="dsc">멤버선택 후 대화를 시작해주세요.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(LayerManager|HideLayer|notExistInviteMemberLayer) _stopDefault">확인</button>
	</div>
</div>


<div id="roomNameInsertionLayer" class="ly_chat_type ly_type_v4" style="display:none;top:400px;left:560px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>방 이름을 만들어주세요. </strong></p>
		<div class="dsc2">
			<em class="chk_byte"><span id="byteLabel">0</span>/40 byte</em>
			
			<input id="roomNameInputField" class="__notnull __byte(1~40) __notspace _click(CafeMemberTab|RemoveDefaultRoomName) _keydown(CafeMemberTab|CreateRoom)" type="text" cols="20" value=""  maxlength="80">
			<div id="roomNameLayerDesc" class="noti" style="display:none;">방 이름을 입력해주세요.</div>
		</div>
	</div>
	<div id="roomNameCaptcha" class="ly_capt" style="display:none;">
		<p class="tit"><strong>보안확인이 필요합니다.</strong></p>
		<p class="dsc">프로그램을 이용한 자동 이용을 방지하기<br>위해 보안 절차를 거치고 있습니다.<br>아래 이미지를 보이는 대로 입력해주세요.</p>
		<div class="capt_img">
			<img id="roomCaptchaImg" src="" width="200" height="90" alt="">
		</div>
		<div class="capt_input">
			<label for="" class="blind">캡챠</label>
			<input id="roomNameCaptchaKey" type="hidden" value="" />
			<input id="roomNameCaptchaValue" class="__notnull __notspace _keydown(CafeMemberTab|CreateRoom)" type="text" cols="20" value="">
			<span class="btn"><button type="button" class="_click(CafeMemberTab|ChangeCaptcha) _stopDefault">새로고침</button></span>
			<p id="roomNameCaptchaDesc" class="noti txt_f" style="display:none;">보안문자를 잘못 입력하셨습니다.</p>
		</div>
    </div>
	<div class="ly_btns">
		<button type="button" class="btn cfm N=a:mem.cfmtitle _click(CafeMemberTab|CreateRoom) _stopDefault">확인</button>
		<button type="button" class="btn cncl N=a:mem.canceltitle _click(LayerManager|HideLayer|roomNameInsertionLayer) _stopDefault">취소</button>
	</div>
</div>


<div id="groupChatConfigUnUseConfirmLayer" class="ly_chat_type ly_type_v2" style="display:none;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>해당 카페 그룹 채팅 설정을 <br><em>사용 안 함</em>으로 설정하시겠습니까?</strong></p>
		<p class="dsc">사용안함으로 설정하시면 해당 카페의 채팅 초대를 <br>받지 않고 개설도 할 수 없습니다. <br>이미 참여중인 채팅방은 정상적으로 이용할 수 있습니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(LayerManager|ClickLayer|groupChatConfigUnUseConfirmLayer|Confirm) _stopDefault">확인</button>
		<button type="button" class="btn cncl _click(LayerManager|HideLayer|groupChatConfigUnUseConfirmLayer) _stopDefault">취소</button>
	</div>
</div>

<script id="oneToOneBlockMemberListTpl" type="text/template">
	{for blockMemberId in blockMemberList}
	<li>
		<div class="inr">
			<em class="txt">{=blockMemberId}</em>
			<span class="btn_unblock"><button type="button" class="_click(OneToOneBlockConfig|ReleaseBlock|{=blockMemberId}) _stopDefault">차단해제</button></span>
		</div>
	</li>
	{/for}
</script>

<script id="groupChatUseConfigListTpl" type="text/template">
	{for cafe in cafeList}
	<li>
		<div class="inr">
			<em class="txt">{=cafe.cafeName}</em>
			<span class="{if cafe.useGroupChat}btn_used{else}btn_unused{/if}"><button type="button" class="_click(GroupChatBlockConfig|ToggleGroupChatUseConfig|{=cafe.cafeId}) _stopDefault">{if cafe.useGroupChat}사용함{else}사용안함{/if}</button></span>
		</div>
	</li>
	{/for}
</script>

<script id="toggleGroupChatUseConfigTpl" type="text/template">
<button type="button" class="_click(GroupChatBlockConfig|ToggleGroupChatUseConfig|{=cafeId}) _stopDefault">{=label}</button>
</script>




<div id="logoutLayer" class="ly_chat_type ly_type_v1" style="display:none;top:0;left:250px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>로그아웃 되었습니다.</strong></p>
		<p class="dsc">네이버 서비스가 로그아웃되었습니다.<br>네이버 로그인 후 사용해주세요.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(LayerManager|MoveLoginPage) _stopDefault">확인</button>
	</div>
</div>
	

<div id="loadingLayer" class="ly_wrap" style="display:none">
	
	
	<div class="ic_loading">페이지를 불러 오는 중입니다.</div>
</div>


<div id="commonLayer" class="ly_chat_type ly_type_v1" style="top:0;left:250px;margin:0;display:none">
	<div class="ly_cont">
		
		<p class="tit"><strong id="commonLayerTitle"></strong></p>
		<p class="dsc" id="commonLayerDesc"></p>
	</div>
	<div class="ly_btns">
		<button id="commonLayerConfirm" type="button" class="btn cfm _click(LayerManager|HideLayer|commonLayer) _stopDefault">확인</button>
	</div>
</div>


<div id="chatRoomCreateLayer" class="ly_chat_type ly_type_v1" style="display:none;top:200px;left:0;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>카페와 멤버를 선택해주세요.</strong></p>
		<p class="dsc">채팅할 카페와 멤버를 선택 후<br><em>채팅방 만들기</em>를 클릭해 주세요.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(LayerManager|HideLayer|chatRoomCreateLayer) _stopDefault">확인</button>
	</div>
</div>


<div id="notAllowMemberLevelLayer" class="ly_chat_type ly_type_v1" style="display:none;top:200px;left:250px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>채팅방을 만들 수 없습니다</strong></p>
		<p class="dsc">멤버등급 <em id="allowMemberLevel"></em> 이상의 멤버만<br>개설하실 수 있습니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(LayerManager|HideLayer|notAllowMemberLevelLayer) _stopDefault">확인</button>
	</div>
</div>


<div id="notAllowOneToOneMemberLevelLayer" class="ly_chat_type ly_type_v1" style="display:none;top:200px;left:250px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>채팅방을 만들 수 없습니다</strong></p>
		<p class="dsc">1:1채팅은 멤버등급 <em id="oneToOneAllowMemberLevel"></em> 이상의 멤버만 개설하실 수 있습니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(LayerManager|HideLayer|notAllowOneToOneMemberLevelLayer) _stopDefault">확인</button>
	</div>
</div>




<!-- [D] 1:1 대화만 가능 (ly_type_v2) -->
<div id="notAllowCafeChatLayer" class="ly_chat_type ly_type_v2" style="display:none;top:200px;left:500px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>채팅방을 만들 수 없습니다</strong></p>
		<p class="dsc">현재 계신 카페의 그룹 채팅 설정이<br><em>사용하지 않음</em>으로 설정되어있어 1:1대화만 가능합니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(LayerManager|HideLayer|notAllowCafeChatLayer) _stopDefault">확인</button>
	</div>
</div>



<div id="unuseCafeChatMemberLayer" class="ly_chat_type ly_type_v2" style="display:none;top:0;left:570px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>카페 그룹 채팅 설정이 <em>사용안함</em> 상태입니다.</strong></p>
		<p class="dsc">환경설정에서 설정을 변경하시면 채팅사용이 가능합니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(LayerManager|HideLayer|unuseCafeChatMemberLayer) _stopDefault">확인</button>
	</div>
</div>


<div id="blockMemberInviteLayer" class="ly_chat_type ly_type_v5" style="display:none;top:560px;left:250px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong><em id="blockMemberId"></em>님과의<br> 1:1대화가 차단 중 입니다.</strong></p>
		<p class="dsc">채팅 환경설정 메뉴에서 <br>차단을 해제할 수 있습니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(LayerManager|HideLayer|blockMemberInviteLayer) _stopDefault">확인</button>
	</div>
</div>


<div id="notiLayer" class="ly_chat_type ly_type_v6" style="top:0;left:250px;margin:0;display:none" >
	<div class="ly_cont">
		
		<div class="bg"><span class="ico_chat"></span></div>
		<p class="tit"><strong id="notiLayerTitle"></strong></p>
		<p class="dsc" id="notiLayerDesc"></p>
	</div>
	<div class="ly_btns">
		<button id="notiLayerConfirm" type="button" class="btn cfm _click(LayerManager|HideLayer|notiLayer) _stopDefault">확인</button>
	</div>
</div>




<script type="text/javascript" src="/static/js/chat_broker/core/CommonBottomScript-1456157935000-749494.js" charset="utf-8"></script>


<script type="text/javascript">
var nsc="cafe.chat",
nclk_evt = 3;
nclk_do();
$Element("<div></div>").html(); // 진도 버그 대응용
var oUtil = new nhn.Utility();
var oChatUtil = new chat.ChatUtil();
var oLayerManager = new chat.LayerManager();
var oResManager = new chat.ResponseManager();
var oValidator = new nhn.Validator({sCharset : "euc-kr"});
</script>





<script type="text/javascript" src="/static/js/chat_broker/ChatHome-1450085581000-109476.js" charset="utf-8"></script>


<script>
var sInitPage = '', g_sLastSelectedCafeId = '';

var oCafeMemberTab = new chat.CafeMemberTab();

var oChatRoomList = new chat.ChatRoomList();

var oOpenRoomList = new chat.OpenRoomList();

var oChatHomeGNB = new chat.ChatHomeGNB({
	'oChatRoomList' : oChatRoomList,
	'oOpenRoomList' : oOpenRoomList,
	'oCafeMemberTab' : oCafeMemberTab,
	'sInitPage' : sInitPage
});
</script>
</body>
</html>