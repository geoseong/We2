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
var g_sCafeId = "15754634";
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
<meta name="jsfooter" content="/jsp/room/include/ScriptChatRoom.jsp" />


<script>
	document.domain='naver.com';
	try{
		document.execCommand("BackgroundImageCache", false, true);
	}catch (err){
	}
</script>
</head>
<body   class="chat">

	<div id="chat_wrap" class="msgr">
	
	<div id="rolling" class="rolling_hz">
		
		<ul class="rolling_lst">
		<li id="first" class="rolling_itm">
			

<div id="chatRoomBody" class="chat_room">
	<div id="chatRoomHeader" class="chat_hd">
		<div class="tit">
			<h2 id="roomName"></h2>
			<em id="memberCnt" class="cnt"></em>
			<span class="ctit" id="cafeName"></span>
		</div>
		<div class="btns">
			 
            <span class="home"><button type="button" class="_opn_chat_home_btn _stopDefault">채팅홈</button></span> 
			<span class="lst"><button type="button" class="_click(ChatRoom|ShowOption) _stopDefault">채팅방 메뉴 보기</button></span>
		</div>
	</div>
	<div class="chat_ct">
		
		<div id="boardContainer" class="chat_msgs_section">
			<h3 class="blind">대화내용</h3>
			
			<div id="notiMsgContainer" class="ly_chat_msg" style="display: none">
				<p class="txt">홍보성 스팸 메시지를 보시면 멤버 프로필을 선택해서 신고해주세요.</p>
			</div>
			
			<div id="prevMsgBtnContainer" class="chat_prv_msgs">
				<button type="button" class="_click(ChatRoom|ShowPrevMsg)">이전대화보기<em></em></button>
				<span class="ic_loading" style="display:none">이전대화 불러오는 중</span>
			</div>
			<div id="boardBody" class="chat_msgs">
			</div>
			<a href="#" id="newMsgContainer" class="chat_new_msgs _click(ChatRoom|MoveToScrollBottom) _stopDefault" style="display:none">
				<strong class="blind">읽지 않은 새 대화</strong>
				<i class="bu"></i>
				<p id="newMsgBody"></p>
			</a>
		</div>
	</div>
	<div class="chat_ft">
		<div class="chat_type">
			<div class="chat_type_inr">
				<div class="txt_area">
					<textarea id="msgInputArea" rows="5" cols="30" maxlength="500" disabled="disabled"></textarea>
				</div>
				<div class="hitwp">
					<span class="pht">
						<form id="photoUploadFrm" method="post" enctype="multipart/form-data" accept-charset="euc-kr">
						<label for="send_photo" class="lb_sndphoto _click(ChatRoom|SendImage)">사진전송</label>
						<input id="send_photo" name="photo" type="file" value="" class="_click(ChatRoom|SendImage)">
						</form>
					</span>
					
					<span class="hit"><button type="button" class="N=a:grp.sticker _click(ChatSticker|ToggleStickerLayer)"><span class="blind">스티커</span></button></span>
					<span class="smt"><button type="button" class="_click(ChatRoom|SendMessage)">전송</button></span>
				</div>
			</div>
		</div>
	</div>
</div>

		</li>
		<li id="second" class="rolling_itm">
			

<div class="chat_room" id="inviteMemberContainer">
	<div class="chat_hd">
		<h3 class="sub">멤버 초대하기</h3>
		<span class="prv"><button type="button" class="_click(ChatRoom|BackToRoom) _stopDefault">채팅방가기</button></span>
	</div>
	<div class="chat_ct">
		
		<div id="rolling_vt" class="rolling_vt">
		
		<ul class="rolling_lst2">
		<li class="rolling_itm2">
			<div class="member_section">
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
		</li>
		<li class="rolling_itm2">
			<div class="member_section2">
				<div id="inviteInfoLayer" class="ly_chat_type3 ly_mem_invite" style="opacity:0;display:none;">
					<div class="ly_cont">
						<p class="txt">추가하였습니다</p>
						<i class="tail"></i>
					</div>
				</div>
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
	<div class="chat_ft">
		<div class="chat_btn">
			<span class="cncl"><button type="button" class="N=a:gri.cancel _click(ChatRoom|BackToRoom) _stopDefault">취소</button></span>
			<span class="invt"><button type="button" class="N=a:gri.invite _click(ChatRoom|InviteRoom) _stopDefault">초대하기</button></span>
		</div>
	</div>
</div>
	

<div id="inviteMemberCaptchaLayer" class="ly_chat_type ly_chat_type4 ly_type_v8" style="display:none;top:990px;left:840px;margin:0">
    <div id="inviteMemberCaptcha" class="ly_capt">
    	<p class="tit"><strong>보안확인이 필요합니다.</strong></p>
        <p class="dsc">프로그램을 이용한 자동 이용을 방지하기<br>위해 보안 절차를 거치고 있습니다.<br>아래 이미지를 보이는 대로 입력해주세요.</p>
        <div class="capt_img">
        	<img id="inviteMemberCaptchaImg" src="" width="200" height="90" alt="">
        </div>
        <div class="capt_input">
			<label for="" class="blind">캡챠</label>
			<input id="inviteMemberCaptchaKey" type="hidden" value="" />
			<input id="inviteMemberCaptchaValue" class="__notnull __notspace _keydown(ChatRoom|InviteRoom)" type="text" cols="20" value="">
			<span class="btn"><button type="button" class="_click(ChatRoom|ChangeInviteCaptcha) _stopDefault">새로고침</button></span>
			<p id="inviteMemberCaptchaDesc" class="noti txt_f" style="display:none;">보안문자를 잘못 입력하셨습니다.</p>
        </div>
    </div>
	<div class="ly_btns">
		<button type="button" class="btn cfm N=a:gri.invite _click(ChatRoom|InviteRoom) _stopDefault">확인</button>
		<button type="button" class="btn cncl N=a:mem.canceltitle _click(LayerManager|HideLayer|inviteMemberCaptchaLayer) _stopDefault">취소</button>
	</div>
</div>
			

<div class="chat_room" id="roomMemberListContainer">
		<div class="chat_hd">
			<h3 class="sub">채팅방 참여자 <span class="num" id="roomMemberListCount">-</span>명</h3>
			<span class="prv"><button type="button" class="_click(ChatRoom|BackToRoom) _stopDefault">채팅방가기</button></span>
		</div>
		<div class="chat_member_section">
			<div class="lst_area">
				<ul id="roomMemberListBody" class="mem_lst">
				</ul>
		</div>
	</div>
</div>
			

<div class="chat_room" id="reportMemberContainer"></div>


<div id="reportAlertLayer" class="ly_chat_type ly_type_v1" style="top:0;left:250px;margin:0;display:none">
	<div class="ly_cont">
		<div class="bg"><span class="ico_chat"></span></div>
		<p class="tit"><strong id="reportAlertLayerTitle"></strong></p>
		<p class="dsc" id="reportAlertLayerDesc"></p>
	</div>
	<div class="ly_btns">
		<button id="reportAlertLayerConfirm"  type="button" class="btn cfm _click(LayerManager|HideLayer|reportAlertLayer) _stopDefault">확인</button>
	</div>
</div>

		</li>
		</ul>
	</div>
</div>


<div id="deleteRoomConfirmLayer" class="ly_chat_type ly_type_v1" style="display:none;top:0;left:0;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>채팅방을 나가시겠습니까?</strong></p>
		<p class="dsc">대화내용이 저장되지 않으며,<br>채팅 목록에서 사라집니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(ChatRoomDelete|DeleteRoom) _stopDefault">확인</button>
		<button type="button" class="btn cncl _click(LayerManager|HideLayer|deleteRoomConfirmLayer) _stopDefault">취소</button>
	</div>
</div>


<div id="closeOpenroomConfirmLayer" class="ly_chat_type ly_type_v1" style="display:none;top:0;left:0;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>채팅방을 종료하시겠습니까?</strong></p>
		<p class="dsc">채팅방이 목록에서 사라지고,<br>채팅방 내 모든 대화가 중단됩니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm N=a:grp.mngcok _click(OpenRoomClose|CloseOpenRoom) _stopDefault">채팅방 종료</button>
		<button type="button" class="btn cncl N=a:grp.mngccancel _click(LayerManager|HideLayer|closeOpenroomConfirmLayer) _stopDefault">취소</button>
	</div>
</div>


<div id="rejectMemberConfirmLayer" class="ly_chat_type ly_type_v1" style="display:none;top:0;left:0;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong><span id="rejectedMemberNickname"></span>님을 강퇴 하시겠습니까?</strong></p>
		<p class="dsc">강퇴된 멤버는 다시 채팅방에,<br>입장할 수 없습니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm N=a:prp.outok _click(LayerManager|ClickLayer|rejectMemberConfirmLayer|Confirm) _stopDefault">확인</button>
		<button type="button" class="btn cncl N=a:prp.cancel _click(LayerManager|HideLayer|rejectMemberConfirmLayer) _stopDefault">취소</button>
	</div>
</div>


<div id="delegateMasterConfirmLayer" class="ly_chat_type ly_type_v1" style="display:none;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>방장 권한을 위임하시겠습니까?</strong></p>
		<p class="dsc">확인을 누르면 바로 방장 권한이 <br><em id="delegatedUserNicknameLabel"></em>님께 위임됩니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm N=a:prp.entrustok _click(LayerManager|ClickLayer|delegateMasterConfirmLayer|Confirm) _stopDefault">확인</button>
		<button type="button" class="btn cncl N=a:prp.entrustcancel _click(LayerManager|HideLayer|delegateMasterConfirmLayer) _stopDefault">취소</button>
	</div>
</div>


<div id="changeRoomNameLayer" class="ly_chat_type ly_type_v4" style="top:200px;left:750px;margin:0;display:none;">
	<div class="ly_cont">
		<p class="tit"><strong>채팅방 이름 변경</strong></p>
		<div class="dsc2">
			<em class="chk_byte"><span id="roomNameChangeByte">0</span>/40 byte</em>
			<input id="roomNameChangeInput" type="text" cols="20" class="__notnull __byte(1~40) __notspace _unvalid" maxlength="80">
			<div id="RoomNameChangeLayerDesc" class="noti" style="display:none;">방 이름을 입력해주세요.</div>
		</div>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(ChatRoom|ChangeRoomName) _stopDefault">확인</button>
		<button type="button" class="btn cncl _click(LayerManager|HideLayer|changeRoomNameLayer) _stopDefault">취소</button>
	</div>
</div>


<div id="insertRoomNameLayer" class="ly_chat_type ly_type_v4" style="display:none;top:400px;left:560px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>방 이름을 만들어주세요. </strong></p>
		<div class="dsc2">
			<em class="chk_byte"><span id="roomNameInserteByte">0</span>/40 byte</em>
			
			<input id="roomNameInsertInput" class="__notnull __byte(1~40) __notspace _click(RoomNameManage|RemoveDefaultRoomName) _keydown(ChatRoom|CreateChatRoom)" type="text" cols="20" value="" maxlength="80">
			<div id="RoomNameInsertLayerDesc" class="noti" style="display:none;">방 이름을 입력해주세요.</div>
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
			<input id="roomNameCaptchaValue" class="__notnull __notspace _keydown(ChatRoom|CreateChatRoom)" type="text" cols="20" value="">
			<span class="btn"><button type="button" class="_click(ChatRoom|ChangeCreateCaptcha) _stopDefault">새로고침</button></span>
			<p id="roomNameCaptchaDesc" class="noti txt_f" style="display:none;">보안문자를 잘못 입력하셨습니다.</p>
		</div>
    </div>
	<div class="ly_btns">
		<button type="button" class="btn cfm N=a:mem.cfmtitle _click(ChatRoom|CreateChatRoom) _stopDefault">확인</button>
		<button type="button" class="btn cncl N=a:mem.canceltitle _click(LayerManager|HideLayer|insertRoomNameLayer) _stopDefault">취소</button>
	</div>
</div>


<div id="notExistInviteMemberLayer" class="ly_chat_type ly_type_v3" style="display:none;top:200px;left:500px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong>멤버를 선택해주세요.</strong></p>
		<p class="dsc">멤버선택 후 <em>초대하기</em>를 클릭해 주세요.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(LayerManager|HideLayer|notExistInviteMemberLayer) _stopDefault">확인</button>
	</div>
</div>

<div id="roomOptions" class="ly_chat_type2 ly_chatroom_menu" style="display:none;">
	<div class="ly_cont">
		<ul class="menu">
		<li id="inviteMenu"><a href="#" class="_click(ChatRoom|ShowInviteMemberView) _stopDefault">멤버 초대하기</a></li>
		<li id="changeRoomNameMenu"><a href="#" class="_click(ChatRoom|ShowRoomNameChangeLayer) _stopDefault">채팅 방제 수정</a></li>
		<li id="addBlockMemberMenu" style="display:none;"><a href="#" class="_click(ChatRoom|ShowAddBlockMemberConfirmLayer) _stopDefault">1:1 대화 차단</a></li>
		<li id="removeBlockMemberMenu" style="display:none;"><a href="#" class="_click(ChatRoom|RemoveBlockMember) _stopDefault">1:1 대화 차단 해제</a></li>
		<li><a href="#" class="_click(ChatRoom|ShowRoomMemberListView) _stopDefault">참여자 보기</a></li>
		<li id="groupChatConfigMenu" style="display:none;"><a href="#" class="N=a:1n1.grpset _click(ChatRoom|ShowGroupChatConfigShowConfirmLayer) _stopDefault">그룹채팅사용</a></li>
		<li id="openRoomCloseMenu" style="display: none;"><a href="#" class="N=a:1n1.mclose _click(OpenRoomClose|ShowCloseOpenroomConfirmLayer) _stopDefault">방 종료</a></li>
		<li><a href="#" class="_click(ChatRoomDelete|ShowDeleteRoomConfirmLayer) _stopDefault">나가기</a></li>
		</ul>
	</div>
</div>

<div id="groupChatConfigShowConfirmLayer" class="ly_chat_type ly_type_v6" style="display:none;top:560px;left:510px;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong><em id="groupChatConfigCafeName"></em> 에서의 <br>그룹 채팅 사용 설정을 변경하시겠습니까?</strong></p>
		<p class="dsc">해당 카페에서의 그룹채팅 사용 여부를 설정할 수 있습니다. <br>[확인] 클릭 시 설정 페이지로 이동합니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(LayerManager|ClickLayer|groupChatConfigShowConfirmLayer|Confirm)_stopDefault">확인</button>
		<button type="button" class="btn cncl _click(LayerManager|HideLayer|groupChatConfigShowConfirmLayer) _stopDefault">취소</button>
	</div>
</div>

<div id="addBlockMemberConfirmLayer" class="ly_chat_type ly_type_v1" style="display:none;top:0;left:0;margin:0">
	<div class="ly_cont">
		<p class="tit"><strong><span id="addBlockMemberId"></span>님과의 1:1대화를 차단하시겠습니까?</strong></p>
		<p class="dsc">대화내용이 저장되지 않으며,<br>채팅 목록에서 사라집니다.</p>
	</div>
	<div class="ly_btns">
		<button type="button" class="btn cfm _click(ChatRoom|AddBlockMember) _stopDefault">확인</button>
		<button type="button" class="btn cncl _click(LayerManager|HideLayer|addBlockMemberConfirmLayer) _stopDefault">취소</button>
	</div>
</div>


<div id="profileViewLayer" class="ly_prof_type" style="display:none;margin:0">
	<div id="profileViewContent" class="ly_cont">
		
	</div>
	<div id="oneToOneChatRequest" class="ly_btm">
		<button type="button" class="btn btn_one_chat N=a:prp.1on1 _click(ProfileView|OpenOneToOneChatRoom) _stopDefault"><i class="ico_chat"></i> <strong>1:1채팅</strong></button>
	</div>
	<button type="button" class="clse _click(LayerManager|HideLayer|profileViewLayer) _stopDefault"><span class="blind">닫기</span></button>
</div>


<div id="stickerLayer" class="se2_line_layer talk" style="display:none">
	<div class="se2_in_layer">
		<h1>스티커<a href="#" class="_click(ChatSticker|HideLayer) _stopDefault">닫기</a></h1>
		<div class="se2_line_sticker">
			
			<button type="button" id="prevPackBtn" title="이전" disabled class="se2_prev _click(ChatSticker|PrevPack) _stopDefault"><span>이전</span></button>
			
			<ul id="stickerPackListUl" class="se2_line_sticker_set" data-selected-pack=""></ul>
			
			<button type="button" id="nextPackBtn" title="다음" disabled class="se2_next _click(ChatSticker|NextPack) _stopDefault"><span>다음</span></button>
		</div>
		<em class="arr_sticker"></em>
	</div>
</div>



<script id="othersMsgTpl" type="text/template">
	<div msgSn="{=msgSn}" class="msg" timestamp="{=timestamp}" {if reportableType} targetId="{=senderId}"{/if}>
		<span class="thmb">
			<a {if isProfileViewSupport}href="#" class="N=a:prp.image _click(ProfileView|ShowProfileLayer{if !isOneToOneLinkSupport}ForOneToOneRoom{/if}|{=senderId}|{=senderNickname}|{=senderProfileUrl}|{=msgSn}) _stopDefault"{/if}>
			{if senderProfileUrl}<img src="{=senderProfileUrl}" alt="{=senderUserLabel}" width="40" height="40">{/if}<i></i></a>
		</span>
		<div class="say">
			<p class="name">{=senderUserLabel}</p>
			{if stickerInfo && stickerInfo.url}
			<div class="bl_pcs bl_pcs_sticker">
				<div class="blm stk_img">
					<img src="{=stickerInfo.url}" width="{=stickerInfo.width}" height="{=stickerInfo.height}" class="_chat_sticker">
				</div>
			{elseif imageInfo && imageInfo.thumbUrl}
			<div class="bl_pcs bl_pcs_picture">
				<div class="blm">
					<div class="picture_img">
						<a href="{=imageInfo.url}" class="_chat_img _click(ChatRoom|OpenImageViewer) _stopDefault" w="{=imageInfo.orgWidth}" h="{=imageInfo.orgHeight}">
							<img src="{=imageInfo.thumbUrl}" width="{=imageInfo.width}" height="{=imageInfo.height}" onerror="retryImage(this)"/>
						</a>
					</div>
				</div>
			{elseif tvcastInfo}
			<div class="bl_pcs bl_pcs_video">
				<div class="blm">
					<a href="{=tvcastInfo.url}" class="_chat_tvcast {if isOneToOneRoom}N=a:1n1.play{else}N=a:grp.play{/if}" target="_blank">
						<div class="video_img">
							<img src="{=tvcastInfo.thumbnailSecure}" width="230" height="130"/>
							<span><i></i><em>{js oChatUtil.convertTimestamp(=tvcastInfo.playtime)}</em></span>
						</div>
						<div class="video_desc">
							<strong>{=tvcastInfo.title}</strong>
							<em>{=tvcastInfo.channel}</em>
						</div>
					</a>
				</div>
			{else}
			<div class="bl_pcs">
				<div class="blm">
					<span class="arrow_bd">
						<span class="arrow_bd_ext"></span> 
						<span class="arrow_bd_int"></span>
					</span>
					<span class="_chat_msg">{=msg}</span>
				</div>
			{/if}
				<div class="stp"><em class="time">{=msgTime}</em></div>
			</div>
		</div>
	</div>
</script>

<script id="myMsgTpl" type="text/template">
	<div msgSn="{=msgSn}" class="my msg" timestamp="{=timestamp}"{if msgId} id="{=msgId}"{/if} >
		<div class="say">
			{if stickerInfo && stickerInfo.url}
			<div class="bl_pcs bl_pcs_sticker">
				<div class="blm">
					<div class="blm stk_img">
						<img src="{=stickerInfo.url}" width="{=stickerInfo.width}" height="{=stickerInfo.height}" class="_chat_sticker">
					</div>
				</div>
			{elseif imageInfo && imageInfo.thumbUrl}
			<div class="bl_pcs bl_pcs_picture">
				<div class="blm">
					<div class="picture_img">
						<a href="{=imageInfo.url}" class="_chat_img _click(ChatRoom|OpenImageViewer) _stopDefault" w="{=imageInfo.orgWidth}" h="{=imageInfo.orgHeight}">
							<img src="{=imageInfo.thumbUrl}" class="{if imageInfo.isLoading}loading{/if}" width="{=imageInfo.width}" height="{=imageInfo.height}" onerror="retryImage(this)"/>
						</a>
					</div>
				</div>
			{elseif tvcastInfo}
			<div class="bl_pcs bl_pcs_video">
				<div class="blm">
					<a href="{=tvcastInfo.url}" class="_chat_tvcast {if isOneToOneRoom}N=a:1n1.play{else}N=a:grp.play{/if}" target="_blank">
						<div class="video_img">
							<img src="{=tvcastInfo.thumbnailSecure}" width="230" height="130"/>
							<span><i></i><em>{js oChatUtil.convertTimestamp(=tvcastInfo.playtime)}</em></span>
						</div>
						<div class="video_desc">
							<strong>{=tvcastInfo.title}</strong>
							<em>{=tvcastInfo.channel}</em>
						</div>
					</a>
				</div>
			{else}
			<div class="bl_pcs">
				<div class="blm">
					<span class="arrow_bd">
						<span class="arrow_bd_ext"></span>
						<span class="arrow_bd_int"></span>
					</span>
					<span class="_chat_msg">{=msg}</span>
				</div>
			{/if}
				<div class="stp"><em class="time">{=msgTime}</em></div>
			</div>
		</div>
	</div>
</script>

<script id="myMsgRetryTpl" type="text/template">
	<div class="btns">
		<span class="btn_retry"><button type="button" class="_click(ChatRoom|ReSendMsg|{=msgId}) _stopDefault">재전송</button></span>
		<span class="btn_del"><button type="button" class="_click(ChatRoom|DeleteSendFailMsg|{=msgId}) _stopDefault">삭제</button></span>
	</div>
</script>

<script id="changeRoomNameTpl" type="text/template">
	<div class="attn">
		<div class="sts">
			<p class="">채팅방 이름이 <em>{=changedRoomName}</em> (으)로 변경되었습니다.</p>
		</div>
	</div>
</script>

<script id="changeMasterTpl" type="text/template">
	<div class="attn">
		<div class="sts">
			<p class="">방장이 <em>{=delegatedUserLabel}</em> 님으로 변경되었습니다.</p>
		</div>
	</div>
</script>

<script id="rejectMemberTpl" type="text/template">
	<div class="attn">
		<div class="sts">
			<p class="">방장 <em>{=masterUserLabel}</em>님이  <em>{=rejectedUserLabel}</em>님을 대화방에서 제외했습니다.</p>
		</div>
	</div>
</script>

<script id="leaveTpl" type="text/template">
	<div class="attn">
		<div class="sts">
			<p class=""><em>{=leaveUserLabel}</em> 님이 퇴장하셨습니다.</p>
		</div>
	</div>
</script>

<script id="memberListItemTpl" type="text/template">
	<li class="{if isMySelf} my{/if}{if isMaster} adm{/if}">
		<div class="pers_nick">
			<div class="inr">
				<{if isProfileViewSupport}a href="#"{else}span{/if} class="thmb{if isProfileViewSupport} N=a:prp.image _click(ProfileView|ShowProfileLayer|{=id}|{=nickname}|{=profileUrl}) _stopDefault{/if}">{if profileUrl}<img src="{=profileUrl}" width="30" height="30" alt="">{/if}<i></i></{if isProfileViewSupport}a{else}span{/if}>
				<em class="txt">{=userLabel}</em>
				{if isMySelf}
				<span class="btn_set"><button type="button" class="_click(ChatRoom|EditMyInfo) _stopDefault">별명 및 내 정보 설정</button></span>
				{/if}
				{if isMaster}
				<span class="ic_adm">방장</span>
				{/if}
			</div>
		</div>
	</li>
</script>


<script id="inviteMemberListNotiTpl" type="text/template">
	<div class="attn">
		<div class="sts">
			<p class="">{if groupChatBlockedMemberList}<em>{=groupChatBlockedMemberList}</em> 님{if nBlockedMemberEtcNum} 외 {=nBlockedMemberEtcNum}명{/if}은 카페 채팅 사용 설정안함 상태입니다.<br/>{/if}<em>{=inviter}</em> 님이 <em>{=inviteeList}</em> 님{if nEtcNum} 외 {=nEtcNum}명{/if}을 초대했습니다.</p>
		</div>
	</div>
</script>

<script id="memberCountTpl" type="text/template">
	({=memberCnt})
</script>

<script id="dateTpl" type="text/template">
<div class="attn">
	<div class="sts">
		<p>{=dateLabel}</p>
	</div>
</div>
</script>


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
					<button type="button" class="btn_act {if member.alreadyJoin}chat{else}add{/if} _click(InviteRoomMember|ToggleInviteMember|{=member.memberId}|{=member.nickname}|{=member.memberProfileImageUrl}) _stopDefault">바로추가</button>
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

<script id="inviteMemberTpl" type="text/template">
	<li id="invite_{=memberId}" class="_memberId({=memberId}|{=nickname})">
		<div class="pers_nick">
			<div class="inr">
				<span class="thmb">{if profileImage}<img src="{=profileImage}" width="30" height="30" alt="">{/if}<i></i></span>
				<em class="txt">{=nickname}</em>
				<button type="button" class="btn_act del _click(InviteRoomMember|ToggleInviteMember|{=memberId}) _stopDefault">초대취소</button>
			</div>
		</div>
	</li>
</script>

<script id="addBlockMemberTpl" type="text/template">
	<div class="attn">
		<div class="sts">
			<p class=""><em>{=targetLabel}</em> 님과의 1:1대화를 차단했습니다.</p>
		</div>
	</div>
</script>

<script id="removeBlockMemberTpl" type="text/template">
	<div class="attn">
		<div class="sts">
			<p class=""><em>{=targetLabel}</em> 님과의 1:1대화 차단을 해제했습니다.</p>
		</div>
	</div>
</script>

<script id="profileViewTpl" type="text/template">
<span class="thmb">{if profileImageUrl}<img src="{=profileImageUrl}" width="70" height="70" alt="">{/if}<i></i></span>
<div class="info {if enableReport}info_v1{elseif isMaster && !isOneToOneRoom}info_v1{/if}">
	<div class="prof">
		<strong>{=nickname}</strong>
	</div>
	<div class="acts" style="display:block">
		{if isMaster && !isOneToOneRoom}
		<button type="button" class="btn N=a:prp.entrust _click(ProfileView|DelegateRoomMasterConfirmLayer)">방장위임</button>
		<button type="button" class="btn N=a:prp.out _click(ProfileView|ShowRejectMemberConfirmLayer)">강제퇴장</button>
		{/if}
		{if enableReport}
		<button type="button" class="btn N=a:{if isOneToOneRoom}1n1{else}grp{/if}.report _click(Report|ShowReportMemberView|{=userId}|{=nickname}|{=msgSn}) _stopDefault">신고</button>
		{/if}
	</div>
</div>
</script>

<script id="joinRoomTpl" type="text/template">
	<div class="attn">
		<div class="sts">
			<p class=""><em>{=joinUserLabel}</em> 님이 참여했습니다.</p>
		</div>
	</div>
</script>

<script id="openRoomCreateGreetingTpl" type="text/template">
	<div class="attn">
		<div class="sts">
			<p class=""><em>{=masterUserLabel}</em> 님의 공개방 개설을 환영합니다.</p>
		</div>
	</div>
</script>

<script id="progressBarTpl" type="text/template">
<p class="_progressBarMain photo_prg">
	<a href="#" class="btn_cancel _click(ChatRoom|CancelSendMsg|{=msgId})"><span class="blind">사진 업로드 취소</span></a>
	<span class="prg_bar">
		
		<span class="_progressBar current" style="width:0%"><em class="blind">40% 진행중</em></span>													
	</span>
</p>
</script>

<script id="reportMemberTpl" type="text/template">
	
	<div class="ly_report" style="display: block">
		<div class="chat_hd">
			<h3 class="sub">신고하기</h3>
			<span class="prv"><button type="button" class="_click(ChatRoom|BackToRoom) _stopDefault">채팅방가기</button></span>
		</div>
		<div class="c_rp_top">
			<div class="c_rp_dtl">
				<em class="c_rp_dtlt">방이름</em><p class="c_rp_dtlw" id="reportRoomName">{=reportRoomName}</p>
			</div>
			<div class="c_rp_dtl">
				<em class="c_rp_dtlt">참여자</em><p class="c_rp_dtlw" id="reportTargetMember">{=reportTargetMemberNickname}</p>
			</div>
			<div class="c_rp_dtl">
				<em class="c_rp_dtlt">내 용</em><p class="c_rp_dtlc" id="reportMsg">{=reportMsg}</p>
			</div>
		</div>
		<form id="reportType">
		<div class="c_rp_lst">
			<ul class="wp">
				<li class="itm"><label class="lbl"><input type="radio" name="rd_rprt" class="inprd" value="S">부적절한 홍보성 스팸 메시지</label></li>
				<li class="itm"><label class="lbl"><input type="radio" name="rd_rprt" class="inprd" value="A">음란성 또는 청소년에게 부적합한 메시지</label></li>
				<li class="itm"><label class="lbl"><input type="radio" name="rd_rprt" class="inprd" value="I">불법 내용의 메시지</label></li>
			</ul>
		</div>
		</form>
		<p id="reportMsgList"></p>
		<div class="c_rp_btnar">
			<a href="#" class="N=a:{if isOneToOneRoom}1n1{else}grp{/if}.reportok btn report _click(Report|SendReport)">신고하기</a> <a href="#" class="btn cncl _click(ChatRoom|BackToRoom)">취소</a>
		</div>
	</div>
</script>

<script id="closedRoomTpl" type="text/template">
	<div class="attn">
		<div class="sts">
			<p class="">카페 매니저에 의해 종료된 채팅방입니다.</p>
		</div>
	</div>
</script>

<script id="stickerPackListTpl" type="text/template">
	<li id="{=packCode}"> 
		<button type="button" class="_pack_btn _click(ChatSticker|ShowPack)" data-pack-code="{=packCode}"
				style="background:url('{=imageUrl}') center no-repeat"></button>
		<div class="scroll _pack_body">
			<div class="scroller se2_linesticker_list">
				<ul class="_sticker_list">
				</ul>
			</div>
		</div>
	</li>
</script>

<script id="stickerTpl" type="text/template">
	<li>
		<a href="#" id="{=stickerId}" class="_sticker_btn {if isOneToOneRoom}N=a:1n1.stickersend{else}N=a:grp.stickersend{/if} _click(ChatSticker|SendSticker)" style="background:url('{=previewImageUrl}') {=pos} no-repeat"
					data-sticker-id="{=stickerId}" data-image-url="{=imageUrl}" data-image-width="{=imageWidth}" data-image-height="{=imageHeight}">
			<span>{=stickerId}</span>
		</a>
	</li>
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





<script type="text/javascript">
	var sCafeId = '15754634';
	var sRoomId = 'wsj3792:1441130118688';
	var sSSId = '1';
	var sUserAgent = navigator.userAgent;
	var isOpera = sUserAgent.indexOf("Opera") > -1;
	var isIE = sUserAgent.indexOf("compatible") > -1 
	           && sUserAgent.indexOf("MSIE") > -1
	           && !isOpera;
</script>
<script type="text/javascript" src="/static/js/chat_broker/ChatRoom-1450085581000-316788.js" charset="utf-8"></script>


<script type="text/javascript">
	oChatRoomDoc = new chat.ChatRoomDocument();
	oChatRoomMessage = new chat.ChatRoomMessage();

	oChatRoom = new chat.ChatRoom({
		'cafeId' : sCafeId,
		'roomId' : sRoomId,
		'document' : oChatRoomDoc
	});

	oProfileDoc = new chat.ProfileDocument();

	oProfileView = new chat.ProfileView({
		'document' : oProfileDoc,
		'chatRoomObj' : oChatRoom
	});
	
	oReport = new chat.Report({
		'chatRoomObj' : oChatRoom,
		'chatRoomDocObj' : oChatRoomDoc
	});

	function retryImage(el) {
		setTimeout(function() {
			el.src = el.src + '&timestamp=' + new Date().getTime();	
		}, 500);
	}

	oChatSticker = new chat.ChatSticker({
		sPackListUrl : g_sChatBrokerCommonUrl + '/gfmarket_sticker/StickerPackListAsync.nhn',
		sStickerListUrl : g_sChatBrokerCommonUrl + '/gfmarket_sticker/StickerListAsync.nhn',
		sSSLStickerImageUrl : g_sStickerImageUrl,
		sStickerLayerId : 'stickerLayer',
		sPackListUlId : 'stickerPackListUl',
		sPrevPackBtnId : 'prevPackBtn',
		sNextPackBtnId : 'nextPackBtn',
		oLayerManager : oLayerManager,
		oChatRoom : oChatRoom,
		oChatRoomDoc : oChatRoomDoc
	});
</script>
</body>
</html>