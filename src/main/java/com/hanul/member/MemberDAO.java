package com.hanul.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private String nameSpace = "memberMapper.";
	
	public int insert(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(nameSpace+"insert", memberDTO);
	}
}
