package com.hanul.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "memberMapper.";
	// NAMESPACE 멤버 변수 설정시, static final 사용(다른 dao에서 사용 못하게)
	
	
	public int join(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"join", memberDTO);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"login", memberDTO);
	}
	
	public int update(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"update", memberDTO);
	}
	
	public int delete(String id) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", id);
	}
	
	public String checkId(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"checkId", id);
	}
	
	public MemberDTO myPage(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"myPage", id);
	}
}
