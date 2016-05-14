package com.we2.spring;

public class AuthService {

	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public AuthInfo authenticate(String userId, String password) {
			System.out.println("authService SQL문실행 이전.");
		Member member = memberDao.selectByUserid(userId);
			System.out.println("authService SQL문실행 이후.");
		if (member == null) {
				System.out.println("member==null");
			throw new IdPasswordNotMatchingException();
		}
		if (!member.matchPassword(password)) {
				System.out.println("member pwd!=null");
			throw new IdPasswordNotMatchingException();
		}
		return new AuthInfo(member.getUserId(), member.getName(), member.getEmail(),  member.getPhone(), member.getGender());
		}
}
