package com.we2.spring;

public class AuthService {

	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public AuthInfo authenticate(String userId, String password) {
		Member member = memberDao.selectByUserid(userId);
		if (member == null) {
				System.out.println("member==null");
			throw new IdPasswordNotMatchingException();
		}
		if (!member.matchPassword(password)) {
				System.out.println("member pwd!=null" +"AuthService에서 디버깅중...");
			throw new IdPasswordNotMatchingException();
		}
		System.out.println("userId" + "123456789");
		System.out.println(member.getUserId()+"authservice에서 디버깅중....");
		return new AuthInfo(member.getUserId(), member.getName(), member.getEmail(),  member.getPhone(), member.getGender());
		}
	
	public int idCheck(String userId){
		return memberDao.confirmID(userId);
	}
	
	
	
}
