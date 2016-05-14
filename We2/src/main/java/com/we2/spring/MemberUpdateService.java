package com.we2.spring;


import org.springframework.transaction.annotation.Transactional;

public class MemberUpdateService {

	private MemberDao memberDao;

	public MemberUpdateService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Transactional
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = MemberDao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();
		
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}
}
