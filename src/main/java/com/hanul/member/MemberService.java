package com.hanul.member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Inject
	private MemberDAO memberDAO;
	
	public int join(MemberDTO memberDTO) throws Exception{
		return memberDAO.join(memberDTO);
	}
	
	public String checkId(String id) throws Exception{
		return memberDAO.checkId(id);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return memberDAO.login(memberDTO);
	}
	
	public int update(MemberDTO memberDTO) throws Exception{
		return memberDAO.update(memberDTO);
	}
	
	public int delete(String id) throws Exception{
		return memberDAO.delete(id);
	}
	
	public MemberDTO myPage(String id) throws Exception{
		return memberDAO.myPage(id);
	}
}
