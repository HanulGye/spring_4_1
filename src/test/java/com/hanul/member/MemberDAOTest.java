package com.hanul.member;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.hanul.spring_4_1.AbstractTestCase;

public class MemberDAOTest extends AbstractTestCase {

	@Inject
	MemberDAO memberDAO;
	
	//@Test
	public void joinTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("testid222");
		memberDTO.setPw("testid222");
		memberDTO.setName("kim");
		memberDTO.setEmail("aaa@aaa.com");
		memberDTO.setPhone("010-1234-1234");
		memberDTO.setAddress("asdfasdf");
		int result = memberDAO.join(memberDTO);
		assertNotEquals(0, result);
	}
	
	//@Test
	public void LoginTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("testid222");
		memberDTO.setPw("testid222");
		
		MemberDTO memberDTO2 = memberDAO.login(memberDTO);
		assertNotNull(memberDTO2.getAddress());
	}
	
	//@Test
	public void updateTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName("choi");
		memberDTO.setEmail("bbb@aaa.com");
		memberDTO.setPhone("010-1234-5978");
		memberDTO.setAddress("asdfasdf");
		memberDTO.setId("testid222");
		
		int result = memberDAO.update(memberDTO);
		assertNotEquals(0, result);
	}
	
	public void deleteTest() throws Exception{
		String id = "testid222";
		int result = memberDAO.delete(id);
		assertNotEquals(0, result);
	}

}
