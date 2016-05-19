package com.we2.spring;

public class AuthService {

	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	//디비를 통해서 해당 멤버의 정보를 가져오고, 멤버에 담는다. 그리고 AuthinFo 칼럼에 맞게 반환해준다.
	public AuthInfo authenticate(String userId, String password) {
		Member member = memberDao.selectByUserid(userId);
		if (member == null) {
				System.out.println("member==null");
			throw new IdPasswordNotMatchingException();
		}
		if (!member.matchPassword(password)) {
				System.out.println("member pwd!=null" +"AuthService�뿉�꽌 �뵒踰꾧퉭以�...");
			throw new IdPasswordNotMatchingException();
		}
		System.out.println("userId" + "123456789");
		System.out.println(member.getUserId()+"authservice�뿉�꽌 �뵒踰꾧퉭以�....");
		
		return new AuthInfo(member.getUserId(), member.getName(), member.getEmail(),  member.getPhone(), member.getGender());
		}
	
	public int idCheck(String userId){
		return memberDao.confirmID(userId);
	}
}
