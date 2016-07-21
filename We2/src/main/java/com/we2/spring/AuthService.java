package com.we2.spring;

public class AuthService {

	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		System.out.println(memberDao.toString()+"memberDao:::주입됨 ");
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
		
		AuthInfo ai = new AuthInfo(member.getUserId(), member.getName(), member.getEmail(),  member.getPhone(), member.getGender(), member.getRegDate());
		
		return ai;
		}
	
	public int idCheck(String userId){
		return memberDao.confirmID(userId);
	}
}
